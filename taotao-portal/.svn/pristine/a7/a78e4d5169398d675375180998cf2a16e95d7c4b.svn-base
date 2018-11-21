package csc.hfz.taotao.portalservice;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.commons.HttpClientUtil;
import com.taotao.commons.TaotaoResult;

import csc.hfz.taotao.portalpojo.ItemResult;

@Service
public class searchResultImpl implements searchResult{
    
	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;
	
	@Override
	public ItemResult search(String queryString, int page) {
		//参数
		Map<String, String> parmMap=new HashMap<String, String>();
		parmMap.put("q",queryString);
		parmMap.put("page",page+"");
		//调用服务
		String json=HttpClientUtil.doGet(SEARCH_BASE_URL,parmMap);
		//转换java
		TaotaoResult javaResult=TaotaoResult.formatToPojo(json,ItemResult.class);
		if (javaResult.getStatus()==200) {
			ItemResult result=(ItemResult) javaResult.getData();
			return result;
		}
		return null;
	}

}
