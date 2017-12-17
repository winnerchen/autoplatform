package yiheng.chen.cms.service;


import yiheng.chen.cms.mapper.UserMapper;
import yiheng.chen.cms.model.User;
import yiheng.chen.cms.model.UserVO;

import java.util.List;
import java.util.Map;


/**
 * user service interface
 */
public interface UserService extends BaseService<UserMapper> {

	/**
	 * get user with book data
	 * @param id
	 * @return
	 */
	UserVO selectUserWithBook(int id);

	/**
	 * conditional user list query
	 * @param map
	 * @return
	 */
	List<User> selectAll(Map<String, Object> map);

	/**
	 * insert user
	 * @param user
	 */
	void insertAutoKey(User user);
	
}