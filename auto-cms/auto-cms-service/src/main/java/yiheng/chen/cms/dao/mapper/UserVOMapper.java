package yiheng.chen.cms.dao.mapper;

import org.springframework.stereotype.Repository;
import yiheng.chen.cms.dao.model.UserVO;


@Repository
public interface UserVOMapper extends UserMapper {

	UserVO selectUserWithBook(int id);
	

	
}