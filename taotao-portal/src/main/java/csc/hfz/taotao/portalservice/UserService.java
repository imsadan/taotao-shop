package csc.hfz.taotao.portalservice;

import com.taotao.pojo.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}
