package yiheng.chen.cms.service.frontcontroller;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 11:05 2018/1/16
 * @Modified by:
 */
public class Dispatcher {
    private HomeView homeView;
    private StudentView studentView;

    public Dispatcher() {
        homeView = new HomeView();
        studentView = new StudentView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("home")) {
            homeView.show();
        } else {
            studentView.show();
        }
    }
}
