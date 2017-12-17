package yiheng.chen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yiheng.chen.mapper.UserMapper;
import yiheng.chen.mapper.UserVOMapper;
import yiheng.chen.model.User;
import yiheng.chen.model.UserVO;
import yiheng.chen.service.UserService;

import java.util.List;
import java.util.Map;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserVOMapper userVOMapper;

	/**
	 * get basic mapper
	 * @return
	 */
	@Override
	public UserMapper getMapper() {
		return userMapper;
	}
	
	/**
	 * get user with book data
	 * @param id
	 * @return
	 */
	@Override
	public UserVO selectUserWithBook(int id) {
		return userVOMapper.selectUserWithBook(id);
	}

	/**
	 * conditional user list query
	 * @param map
	 * @return
	 */
	@Override
	public List<User> selectAll(Map<String, Object> map) {
		return userVOMapper.selectAll(map);
	}

	/**
	 * insert user
	 * @param user
	 */
	@Override
	public void insertAutoKey(User user) {
		userVOMapper.insertAutoKey(user);
	}

	
}