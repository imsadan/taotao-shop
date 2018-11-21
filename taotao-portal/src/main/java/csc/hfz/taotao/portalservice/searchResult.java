package csc.hfz.taotao.portalservice;

import csc.hfz.taotao.portalpojo.ItemResult;

//搜索查询
public interface searchResult {
   ItemResult search(String queryString,int page);
}
