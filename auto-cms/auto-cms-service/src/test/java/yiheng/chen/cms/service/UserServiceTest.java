package yiheng.chen.cms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


import yiheng.chen.cms.model.User;
import yiheng.chen.cms.model.UserVO;

/**
 * @Author: Yiheng Chen
 * @Description: test service
 * @Date: Created in 11:31 2017/12/17
 * @Modified by:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:applicationContext.xml",
        "classpath:applicationContext-jdbc.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void index() {
        // 自定义接口调用

        UserVO userVO = userService.selectUserWithBook(1);
        System.out.println("======================my result=====================");
        System.out.println(userVO.getBooks().size());
        // 自动生成接口调用
        User user2 = userService.getMapper().selectByPrimaryKey(1);
        System.out.println(user2.getNickname());
    }
}
