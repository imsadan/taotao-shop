package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.commons.EUdatePage;
import com.taotao.commons.TaotaoResult;
import com.taotao.commons.TreeNode;
import com.taotao.service.contentCateService;

@Controller
@RequestMapping("/content/category")
public class contentCategoryController {
     @Autowired
     private contentCateService contentCateService;
     
     @RequestMapping("/list")
     @ResponseBody
     public List<TreeNode> getCategoryli(@RequestParam(value="id"
     ,defaultValue="0")long parentId){
    	 List<TreeNode> list=contentCateService.getContentCatList(parentId);
    	 return list;
     }
     
     @RequestMapping("/create")
     @ResponseBody
     public TaotaoResult createCategory(long parentId,String name){
    	 TaotaoResult result=contentCateService.createContentCat(parentId, name);
    	 return result;
     }
     
     @RequestMapping(value="/delete")
     @ResponseBody
     public TaotaoResult deleteCategory(long id){
    	 TaotaoResult result=contentCateService.removeContentCat(id);
    	 return result;
     }
     
     @RequestMapping("/update")
     @ResponseBody
     public TaotaoResult editCategory(long id,String name){
    	 TaotaoResult result=contentCateService.updateContentCat(id, name);
    	 return result;
     }
     
}
