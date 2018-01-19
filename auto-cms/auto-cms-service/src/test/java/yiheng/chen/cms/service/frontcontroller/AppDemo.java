package yiheng.chen.cms.service.frontcontroller;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 11:08 2018/1/16
 * @Modified by:
 */
public class AppDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatcheRequest("home");

    }
}
