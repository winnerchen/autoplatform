package yiheng.chen.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yiheng.chen.cms.mapper.UserMapper;
import yiheng.chen.cms.mapper.UserVOMapper;
import yiheng.chen.cms.model.User;
import yiheng.chen.cms.model.UserVO;
import yiheng.chen.cms.service.UserService;

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
}