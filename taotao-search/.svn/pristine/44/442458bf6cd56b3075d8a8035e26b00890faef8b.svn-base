package csc.hfz.taotao.searchdao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import csc.hfz.taotao.searchpojo.Item;
import csc.hfz.taotao.searchpojo.ItemResult;

@Repository
public class searchDaoImpl implements searchDao{
    
	@Autowired
	private SolrServer server;
	
	@Override
	public ItemResult search(SolrQuery query) throws SolrServerException {
		ItemResult result=new ItemResult();
		//查询条件
		QueryResponse response=server.query(query);
		//查询结果
		SolrDocumentList solrDocumentList=response.getResults();
		//获取总数
		result.setRecordNum(solrDocumentList.getNumFound());
		//商品列表
		List<Item> items=new ArrayList<>();
		//高亮
		Map<String, Map<String, List<String>>> highlight=response.getHighlighting();
		//取商品列表
		for (SolrDocument document :solrDocumentList) {
			Item item=new Item();
			item.setId((String) document.get("id"));
			//取高亮显示的结果
			List<String> list = highlight.get(document.get("id")).get("item_title");
			String title = "";
			if (list != null && list.size()>0) {
				title = list.get(0);
			} else {
				title = (String) document.get("item_title");
			}
			item.setTitle(title);
			item.setImage((String) document.get("item_image"));
			item.setPrice((long) document.get("item_price"));
			item.setSell_point((String) document.get("item_sell_point"));
			item.setCategory_name((String) document.get("item_category_name"));
			//添加的商品列表
			items.add(item);
			
		}
		result.setSearchItems(items);
		return result;
	}

}
