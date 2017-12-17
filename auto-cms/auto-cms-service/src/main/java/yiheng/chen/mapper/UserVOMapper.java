package yiheng.chen.mapper;

import org.springframework.stereotype.Repository;
import yiheng.chen.cms.mapper.UserMapper;
import yiheng.chen.cms.model.User;
import yiheng.chen.model.UserVO;

import java.util.List;
import java.util.Map;


@Repository
public interface UserVOMapper extends UserMapper {

	UserVO selectUserWithBook(int id);
	
	List<User> selectAll(Map<String, Object> map);
	
	void insertAutoKey(User user);
	
}