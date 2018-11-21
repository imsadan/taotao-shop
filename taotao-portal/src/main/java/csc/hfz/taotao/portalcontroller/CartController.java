package csc.hfz.taotao.portalcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import csc.hfz.taotao.portalpojo.cartItem;
import csc.hfz.taotao.portalservice.CartService;


/**
 * 购物车Controller
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/add/{itemId}")
	public String addCartItem(@PathVariable Long itemId, 
			@RequestParam(defaultValue="1")Integer num, 
			HttpServletRequest request, HttpServletResponse response) {
		cartService.addCartItem(request, response, itemId, num);
		return "redirect:/cart/success.html";
	}
	
	@RequestMapping("/success")
	public String showSuccess() {
		return "cartSuccess";
	}
	
	@RequestMapping("/cart")
	public String showCart(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<cartItem> list = cartService.getCartItemslist(request, response);
		model.addAttribute("cartList", list);
		return "cart";
	}
	
	@RequestMapping("/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response) {
		cartService.deleteCartItem(itemId, request, response);
		return "redirect:/cart/cart.html";
	}
	
	@RequestMapping("/update/{itemId}/{num}")
	public String ChangeCartNum(@PathVariable Long itemId,@PathVariable Integer num, 
			HttpServletRequest request, HttpServletResponse response){
		cartService.changeCartItemNum(itemId, num, request, response);		
		return "redirect:/cart/success.html";
		
	}
	
}
