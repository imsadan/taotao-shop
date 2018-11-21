package csc.hfz.taotao.orderservice;

import java.util.List;

import com.taotao.commons.TaotaoResult;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

public interface orderService {
    //创建订单
	TaotaoResult createOrder(TbOrder order,List<TbOrderItem> orderList,TbOrderShipping orderShipping);
	
}
