package yiheng.chen.cms.service;


import yiheng.auto.cms.dao.mapper.UserMapper;
import yiheng.chen.cms.dao.model.UserVO;


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


}