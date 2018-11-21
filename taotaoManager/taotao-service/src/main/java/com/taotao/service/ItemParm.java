package com.taotao.service;
import com.taotao.commons.TaotaoResult;
import com.taotao.pojo.TbItemParam;



public interface ItemParm{
	//显示所有
	public TaotaoResult SelectItemParm(long id);
	//添加
	TaotaoResult insertItemParam(TbItemParam param);
}