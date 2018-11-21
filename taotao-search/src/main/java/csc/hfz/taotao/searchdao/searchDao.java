package csc.hfz.taotao.searchdao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

import csc.hfz.taotao.searchpojo.ItemResult;

public interface searchDao {
    ItemResult search(SolrQuery query) throws SolrServerException;
}
