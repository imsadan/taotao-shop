package com.taotao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.commons.EUdatePage;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;

@Service
public class contentQueryList implements contentQueryListService {

	@Autowired
	private TbContentMapper tbContentMapper;

	@Override
	public EUdatePage getContentCatsList(long id, int page, int rows) {
		// 根据category_id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(id);
		// 分页处理
		PageHelper.startPage(page, rows);
		List<TbContent> list = tbContentMapper
				.selectByExampleWithBLOBs(example);
		// 取分页信息
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		EUdatePage result = new EUdatePage();
		result.setRows(list);
		result.setTotal((int) pageInfo.getTotal());
		return result;

	}

}
