package csc.hfz.taotao.orderservice;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.commons.TaotaoResult;
import com.taotao.mapper.TbOrderItemMapper;
import com.taotao.mapper.TbOrderMapper;
import com.taotao.mapper.TbOrderShippingMapper;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

import csc.hfz.taotao.orderJedis.jedisClient;

@Service
public class orderServiceImpl implements orderService {
    
	@Autowired
	private TbOrderMapper tbOrderMapper;	
	@Autowired
	private TbOrderItemMapper tbOrderItemMapper;
	@Autowired
	private TbOrderShippingMapper tbOrderShippingMapper;	
	@Autowired
	private jedisClient jedisClient;
	
	@Value("${ORDER_GEN_KEY}")
	private String ORDER_GEN_KEY;
	@Value("${ORDER_INIT_ID}")
	private String ORDER_INIT_ID;
	@Value("${ORDER_DETAIL_GEN_KEY}")
	private String ORDER_DETAIL_GEN_KEY;
	
	
	@Override
	public TaotaoResult createOrder(TbOrder order, List<TbOrderItem> orderList,
			TbOrderShipping orderShipping) {
		//订单中插入记录
		String redisString=jedisClient.get(ORDER_GEN_KEY);
		if (StringUtils.isBlank(redisString)) {
			jedisClient.set(ORDER_GEN_KEY, ORDER_INIT_ID);
		}
		//创建Id
		long OrderId=jedisClient.incr(ORDER_GEN_KEY);
		//补全pojo的属性
		order.setOrderId(OrderId +"");
		//状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
		order.setStatus(1);
		Date date = new Date();
		order.setCreateTime(date);
		order.setUpdateTime(date);
		//0：未评价 1：已评价
		order.setBuyerRate(0);
		//插入订单明细
		tbOrderMapper.insert(order);
		//补全订单明细
		for (TbOrderItem tbOrderItem : orderList) {
			long orderDetailId = jedisClient.incr(ORDER_DETAIL_GEN_KEY);
			tbOrderItem.setId(orderDetailId + "");
			tbOrderItem.setOrderId(OrderId + ""); 
			//向订单明细插入记录
			tbOrderItemMapper.insert(tbOrderItem);
		}
		//插入物流表
		//补全物流表的属性
		orderShipping.setOrderId(OrderId+"");
		orderShipping.setCreated(date);
		orderShipping.setUpdated(date);
		tbOrderShippingMapper.insert(orderShipping);		
		return TaotaoResult.ok(OrderId);
	}

}
