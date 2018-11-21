package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.TaotaoResult;
import com.taotao.service.RestEdits;

@Controller
@RequestMapping("/rest")
public class RestController {
    @Autowired
    private RestEdits restEdits;
    
    @RequestMapping("/content/edit")
    @ResponseBody
    public TaotaoResult editContentCats(long categoryId,String pic,String pic2,
			String title,String titleDesc,String subTitle,String url){
    	TaotaoResult result=restEdits.EditContentCat( categoryId, pic, pic2, title, titleDesc, subTitle, url);
    	return result;
    }
}
