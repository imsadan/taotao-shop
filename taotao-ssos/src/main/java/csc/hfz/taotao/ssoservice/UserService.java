package csc.hfz.taotao.ssoservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.commons.TaotaoResult;
import com.taotao.pojo.TbUser;

public interface UserService {
   //校验
	TaotaoResult checkTbUser(String content,Integer type);
	//创建用户
	TaotaoResult createUser(TbUser user);
	//登录
	TaotaoResult userLogin(String username,String password,
			HttpServletRequest request, HttpServletResponse response);
	//token中取用户登录
	TaotaoResult getUserByToken(String token);
}
