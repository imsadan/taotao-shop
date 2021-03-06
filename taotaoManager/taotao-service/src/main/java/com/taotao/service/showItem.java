package com.taotao.service;

import java.util.List;

import com.taotao.commons.EUdatePage;
import com.taotao.commons.TaotaoResult;
import com.taotao.commons.TreeNode;
import com.taotao.pojo.TbItem;

public interface showItem {
	//选择打印所有
    TbItem select(long tbitemId);
    //打印产品的列表
    EUdatePage getsEUdatePage(int page,int rows);
    //添加目录下的tree分支
    List<TreeNode> getItemsList(long id);
    //提交
    TaotaoResult insertItem(TbItem item,String Desc,String itemParam);
    //参数列表
    EUdatePage getItemParamsList(int page,int rows);

}
