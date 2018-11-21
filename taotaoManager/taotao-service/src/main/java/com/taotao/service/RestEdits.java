package com.taotao.service;

import com.taotao.commons.TaotaoResult;

public interface RestEdits {
    //内容管理的编辑
	TaotaoResult EditContentCat(long categoryId,String pic,String pic2,
			String title,String titleDesc,String subTitle,String url);
}
