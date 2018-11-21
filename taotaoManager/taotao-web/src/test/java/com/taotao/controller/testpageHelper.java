package com.taotao.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class testpageHelper {
   public static void main(String[] args) {
	   //创建spring容器管理
	   ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/springApplication-*.xml");
       TbItemMapper mapper=applicationContext.getBean(TbItemMapper.class);
       TbItemExample example=new TbItemExample();
	  //查询，分页
       PageHelper.startPage(1, 10);
       List<TbItem> list=mapper.selectByExample(example);
       for(TbItem tbItem:list){
    	   System.out.println(tbItem.getTitle());
       }
       
       //取分页信息
       PageInfo<TbItem> pageInfo=new PageInfo<>(list);
       long num=pageInfo.getTotal();
       System.out.println("数据:"+num);
       
}
}
