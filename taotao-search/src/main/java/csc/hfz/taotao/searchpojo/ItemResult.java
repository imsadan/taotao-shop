package csc.hfz.taotao.searchpojo;

import java.util.List;

public class ItemResult {
	// 返回列表
	private List<Item> searchItems;
	// 总数
	private long recordNum;
	// 总页数
	private long pageNum;
	// 当前页
	private long NowNum;

	public List<Item> getSearchItems() {
		return searchItems;
	}

	public void setSearchItems(List<Item> searchItems) {
		this.searchItems = searchItems;
	}

	public long getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(long recordNum) {
		this.recordNum = recordNum;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public long getNowNum() {
		return NowNum;
	}

	public void setNowNum(long nowNum) {
		NowNum = nowNum;
	}

}
