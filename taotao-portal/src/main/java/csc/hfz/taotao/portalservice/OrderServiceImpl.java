package csc.hfz.taotao.portalservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.commons.HttpClientUtil;
import com.taotao.commons.TaotaoResult;
import com.taotao.commons.ftp.JsonUtils;

import csc.hfz.taotao.portalpojo.order;

@Service
public class OrderServiceImpl implements OrderService {
    
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	
	@Override
	public String OrderCart(order order) {
		String json=HttpClientUtil.doPostJson(ORDER_BASE_URL+ORDER_CREATE_URL,JsonUtils.objectToJson(order));
		//转换成taotao对象
		TaotaoResult result=TaotaoResult.format(json);
		if (result.getStatus()==200) {
			 Object orderId=result.getData();
			return orderId.toString();
		}
		
		return "";
	}

}
