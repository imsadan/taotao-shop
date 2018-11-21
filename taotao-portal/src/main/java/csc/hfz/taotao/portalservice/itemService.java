package csc.hfz.taotao.portalservice;


import csc.hfz.taotao.portalpojo.ItemInfo;

public interface itemService {
    //获取基本信息
	ItemInfo getItemById(long id);
    //获取描述
	String getItemDescById(long id);
    //获取规格
	String getItemParam(long id);
}
