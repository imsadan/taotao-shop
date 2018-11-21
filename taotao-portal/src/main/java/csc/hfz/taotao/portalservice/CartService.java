package csc.hfz.taotao.portalservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.commons.TaotaoResult;

import csc.hfz.taotao.portalpojo.cartItem;

public interface CartService {
   //添加商品到购物车
	TaotaoResult addCartItem(HttpServletRequest request,HttpServletResponse response,
			  long id,int num);
	//展现购物车商品列表
	List<cartItem> getCartItemslist(HttpServletRequest request,HttpServletResponse response);
    //删除商品
	TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
	//直接修改数量
	TaotaoResult changeCartItemNum(long itemId,int num,
			HttpServletRequest request,HttpServletResponse response);
}
