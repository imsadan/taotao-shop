package com.taotao.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.commons.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;


@Service
public class RestEditsImpl implements RestEdits {
    
	@Autowired
	private TbContentMapper tbContentMapper;
	
	@Override
	public TaotaoResult EditContentCat(long categoryId,String pic,String pic2,
			String title,String titleDesc,String subTitle,String url) {
		TbContent content=new TbContent();
		content.setCategoryId(categoryId);
		content.setPic(pic);
		content.setPic2(pic2);
		content.setTitle(title);
		content.setTitleDesc(titleDesc);
		content.setSubTitle(subTitle);
		content.setUrl(url);
		content.setUpdated(new Date());
		tbContentMapper.updateByPrimaryKey(content);
		
		return TaotaoResult.ok();
	}

}
