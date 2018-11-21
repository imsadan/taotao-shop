package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.TreeNode;
import com.taotao.service.showItem;

@Controller
@RequestMapping("/item/cat")
public class showCatItemController {
	 
	     @Autowired
	     private showItem showItem;
	     
	   //商品列单
	     @RequestMapping("/list")
	     @ResponseBody
	     public List<TreeNode> getItemCatList(@RequestParam
	   		  (value="id",defaultValue="0")Long id){
	   		List<TreeNode> list=showItem.getItemsList(id);	
	   	  return list;
	   	  
	  }
}
