package csc.hfz.taotao.ssoservice;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.taotao.commons.TaotaoResult;
import com.taotao.commons.ftp.CookieUtils;
import com.taotao.commons.ftp.JsonUtils;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;

import csc.hfz.taotao.ssoJedis.jedisClient;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private TbUserMapper tbUserMapper;
	
	@Autowired
	private jedisClient jedisClient;
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;
	@Value("${SSO_SESSION_EXPIRE}")
	private int SSO_SESSION_EXPIRE;
	
	@Override
	public TaotaoResult checkTbUser(String content, Integer type) {
		//1,2,3分别表示username,phone,email
		//创建查询的条件
		TbUserExample example=new TbUserExample();
		Criteria criteria=example.createCriteria();
		if (1==type) {
			criteria.andUsernameEqualTo(content);
		}else if (2==type) {
			criteria.andPhoneEqualTo(content);
		}else {
			criteria.andEmailEqualTo(content);
		}
		//查询
		List<TbUser> list=tbUserMapper.selectByExample(example);
		if (list==null||list.size()==0) {
			return TaotaoResult.ok(true);
		}
		return TaotaoResult.ok(false);
	}
    
	
	@Override
	public TaotaoResult createUser(TbUser user) {
		user.setUpdated(new Date());
		user.setCreated(new Date());
		//加密
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
	    tbUserMapper.insert(user);
		return TaotaoResult.ok();
	}
    
	
	@Override
	public TaotaoResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		TbUserExample example=new TbUserExample();
		Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list=tbUserMapper.selectByExample(example);
		if (list.size()==0||list==null) {
			return TaotaoResult.build(400, "用户名或密码错误");
			
		}
		TbUser user = list.get(0);
		//比对密码
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			return TaotaoResult.build(400, "用户名或密码错误");
		}
		//生成token
		String token = UUID.randomUUID().toString();
		//保存用户之前，把用户对象中的密码清空。
		user.setPassword(null);
		//把用户信息写入redis
		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		
		//设置session的过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		
		//添加写cookie的逻辑，cookie的有效期是关闭浏览器就失效。
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		
		//返回token
		return TaotaoResult.ok(token);
	}


	@Override
	public TaotaoResult getUserByToken(String token) {
		String json=jedisClient.get(REDIS_USER_SESSION_KEY+":"+token);
		if (StringUtils.isBlank(json)) {
			return TaotaoResult.build(400, "无该密码用户");
		}
		jedisClient.expire(REDIS_USER_SESSION_KEY+":"+token,SSO_SESSION_EXPIRE);
		
		return TaotaoResult.ok(JsonUtils.jsonToPojo(json,TbUser.class));
	}

}
