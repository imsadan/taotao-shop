package csc.hfz.taotao.portalcontroller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import csc.hfz.taotao.portalpojo.ItemResult;
import csc.hfz.taotao.portalservice.searchResult;

@Controller
public class searchController {
	@Autowired
	private searchResult searchResult;
	
	@RequestMapping("/search")
	public String search(@RequestParam("q")String queryString,
			@RequestParam(defaultValue="1")Integer page, Model model) {
		if (queryString != null) {
			try {
				queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		ItemResult itemResult=searchResult.search(queryString, page);
		//向页面传递参数
		model.addAttribute("query", queryString);
		model.addAttribute("totalPages",itemResult.getPageNum());
		model.addAttribute("itemList",itemResult.getSearchItems());
		model.addAttribute("page", page);
		return "search";
		
	}
}
