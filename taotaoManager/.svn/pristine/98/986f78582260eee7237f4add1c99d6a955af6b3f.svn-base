package com.taotao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.EUdatePage;
import com.taotao.commons.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.IdsForm;
import com.taotao.service.contentCateService;
import com.taotao.service.contentQueryListService;


@Controller
@RequestMapping("/content")
public class contentQueryController {
	
	@Autowired
	private  contentCateService contentCateService;
	
	@Autowired
	private contentQueryListService contentQueryListService;
	
	@RequestMapping("/query/list")
    @ResponseBody
    public EUdatePage getContentCategoryList(Long categoryId,int page, int rows){
   	 EUdatePage result=contentQueryListService.getContentCatsList(categoryId, page, rows);
   	 return result;
    }
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult addContent(TbContent content) throws Exception {
		TaotaoResult result = contentCateService.addContentCats(content);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContent(IdsForm ids){
		TaotaoResult result = contentCateService.deleteContentCats(ids);
		return result;
	}

}
