package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.EUdatePage;
import com.taotao.commons.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.showItem;

@Controller
public class showController {
  @Autowired
  private showItem showItem;
  
 @RequestMapping("/")
	public String showIndex() {
		return "index";
	}
 
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}

  //查询所有商品
  @RequestMapping("/item/list")
  @ResponseBody
  public EUdatePage getItem(Integer page,Integer rows){
	  EUdatePage result=showItem.getsEUdatePage(page, rows);
	  return result;
	  
  }
  
  //提交商品
  @RequestMapping(value="/item/save")
  @ResponseBody
  public TaotaoResult insertItem(TbItem item,String desc,String itemParam){
	  TaotaoResult result=showItem.insertItem(item,desc,itemParam);
	  return result;
  }
  
  
}
