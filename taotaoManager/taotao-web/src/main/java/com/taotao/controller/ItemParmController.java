package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.EUdatePage;
import com.taotao.commons.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParm;
import com.taotao.service.showItem;


@Controller
@RequestMapping("/item/param")
public class ItemParmController {
     
	@Autowired
	private ItemParm itemParm;
	
	@Autowired
	private showItem showItem;
	
	
	@RequestMapping("/query/itemcatid/{id}")
	@ResponseBody
	public TaotaoResult showItemParam(@PathVariable long id){
		TaotaoResult result=itemParm.SelectItemParm(id);
		return result;
	}
	
	@RequestMapping("/save/{id}")
	@ResponseBody
	public TaotaoResult insertItem(@PathVariable long id,String paramDate){
		TbItemParam tbItemParam=new TbItemParam();
		tbItemParam.setId(id);
		tbItemParam.setParamData(paramDate);
		TaotaoResult result=itemParm.insertItemParam(tbItemParam);
		return result;
		
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUdatePage getItemParamList(int page,int rows){
		EUdatePage reslut=showItem.getItemParamsList(page, rows);
		return reslut;
	}
	
	
	
}
