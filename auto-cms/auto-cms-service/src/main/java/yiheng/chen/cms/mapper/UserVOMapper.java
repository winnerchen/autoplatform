package yiheng.chen.cms.mapper;

import org.springframework.stereotype.Repository;
import yiheng.chen.cms.model.User;
import yiheng.chen.cms.model.UserVO;

import java.util.List;
import java.util.Map;


@Repository
public interface UserVOMapper extends UserMapper {

	UserVO selectUserWithBook(int id);
	

	
}