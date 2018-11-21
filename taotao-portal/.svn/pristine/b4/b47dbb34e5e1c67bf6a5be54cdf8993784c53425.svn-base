package csc.hfz.taotao.portalcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import csc.hfz.taotao.portalservice.CartService;


@Controller
@RequestMapping("/service")
public class CartChangeNums {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("cart/update/num/{itemId}")
	public String ChangeCartNum(@PathVariable Long itemId, Integer num, 
			HttpServletRequest request, HttpServletResponse response){
		cartService.changeCartItemNum(itemId, num, request, response);		
		return "redirect:/cart/cart.html";
		
	}

}
