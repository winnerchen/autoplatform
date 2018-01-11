package yiheng.chen.cms.task.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import yiheng.chen.cms.task.TestTask;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 13:03 2017/12/23
 * @Modified by:
 */
@Component
public class TestTaskImpl implements TestTask {

    @Scheduled(cron = "0/5 * * * * ?")
    @Override
    public void test() {
        //System.out.println("Task");
    }

}
