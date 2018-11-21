package csc.hfz.taotao.searchservice;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csc.hfz.taotao.searchdao.searchDao;
import csc.hfz.taotao.searchpojo.ItemResult;

@Service
public class searchServiceImpl implements searchService {
    
	@Autowired
	private searchDao searchDao;
	
	@Override
	public ItemResult search(String queryString, int page, int rows) throws SolrServerException {
		//创建查询对象，条件
		SolrQuery query=new SolrQuery();
		query.setQuery(queryString);
		//分页
		query.setStart((page-1)*rows);
		query.setRows(rows);
		//关键域
		query.set("df","item_keywords");
		//高亮
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		//查询
		ItemResult result=searchDao.search(query);
		long recordNum=result.getRecordNum();
		long pageNum=recordNum/rows;
		if (recordNum%rows>0) {
			pageNum++;
		}
		result.setPageNum(pageNum);
		result.setNowNum(page);
		return result;
	}

}