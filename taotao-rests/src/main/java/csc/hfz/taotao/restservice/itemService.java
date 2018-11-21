package csc.hfz.taotao.restservice;

import com.taotao.commons.TaotaoResult;

public interface itemService {
	//查看商品基本信息
   TaotaoResult getItemBaseInfo(long id);
    //查看商品描述信息
   TaotaoResult getItemDescInfo(long id);
   //查看商品规格信息
   TaotaoResult getItemParamInfo(long id);
}
