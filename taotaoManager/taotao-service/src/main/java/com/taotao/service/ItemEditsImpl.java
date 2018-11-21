package com.taotao.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.commons.TaotaoResult;
import com.taotao.mapper.TbItemMapper;

public class ItemEditsImpl implements ItemEdits{
    
	@Autowired
	private TbItemMapper tbItemMapper;
	
	//删除指定商品
	@Override
	public TaotaoResult deleteItem(long id) {
		tbItemMapper.deleteByPrimaryKey(id);
		return TaotaoResult.ok();
	}

}
