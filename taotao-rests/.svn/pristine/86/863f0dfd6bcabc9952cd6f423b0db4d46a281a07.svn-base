package csc.hfz.taotao.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.commons.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;

@Service
public class itemServiceImpl implements itemService {
    
	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;
	
	@Override
	public TaotaoResult getItemBaseInfo(long id) {
		TbItem result=tbItemMapper.selectByPrimaryKey(id);
		return TaotaoResult.ok(result);
	}

	@Override
	public TaotaoResult getItemDescInfo(long id) {
		TbItemDesc tbItemDesc=tbItemDescMapper.selectByPrimaryKey(id);
		return TaotaoResult.ok(tbItemDesc);
	}

	@Override
	public TaotaoResult getItemParamInfo(long id) {
		TbItemParamItemExample example=new TbItemParamItemExample();
		Criteria criteria=example.createCriteria();
		criteria.andItemIdEqualTo(id);
   		List<TbItemParamItem> list=tbItemParamItemMapper.selectByExample(example);
		if (list!=null && list.size()>0) {
			TbItemParamItem paramItem=list.get(0);
			return TaotaoResult.ok(paramItem);
		}
   		return TaotaoResult.build(400,"无此商品规格");
	}

}
