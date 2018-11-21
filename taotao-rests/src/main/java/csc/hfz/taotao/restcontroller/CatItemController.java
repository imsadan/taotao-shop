package csc.hfz.taotao.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.ftp.JsonUtils;

import csc.hfz.taotao.restpojo.CatResult;
import csc.hfz.taotao.restservice.CatService;

@Controller
public class CatItemController {
     
	@Autowired
	private CatService catService;
	
	@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getCatItemList(String callback){
			//查询分类列表
			CatResult result = catService.getCatItemList();
			//把对象转换成json数据
			String jsonResult = JsonUtils.objectToJson(result);
			//拼接字符串
			String resultStr = callback + "(" + jsonResult + ");";
			
			return resultStr;

	}
}
