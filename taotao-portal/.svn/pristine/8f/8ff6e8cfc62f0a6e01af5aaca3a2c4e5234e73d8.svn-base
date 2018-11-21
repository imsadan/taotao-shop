package csc.hfz.taotao.portalcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import csc.hfz.taotao.portalservice.ContentService;

@Controller
public class showController {
	
	@Autowired
	private ContentService contentService;
	
   @RequestMapping("/index")
   public String showIndex(Model model){
		String adJson = contentService.getContentList();
		model.addAttribute("ad1", adJson);
	   return "index";
   }
   
}
