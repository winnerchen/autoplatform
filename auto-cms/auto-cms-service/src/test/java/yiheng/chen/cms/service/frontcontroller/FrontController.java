package yiheng.chen.cms.service.frontcontroller;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 11:06 2018/1/16
 * @Modified by:
 */
public class FrontController {
    private Dispatcher dispatcher;

    public FrontController() {
        dispatcher = new Dispatcher();
    }
    private boolean isAuthenticUser(){
        System.out.println("User is authenticated successfully .");
        return true;
    }
    private void trackRequest(String request){
        System.out.println("request page： "+request);
    }

    public void dispatcheRequest(String request) {
        trackRequest(request);
        if (isAuthenticUser()) {
            dispatcher.dispatch(request);
        }
    }
}
