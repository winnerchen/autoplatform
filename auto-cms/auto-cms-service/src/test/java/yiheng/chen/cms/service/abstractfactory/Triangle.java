package yiheng.chen.cms.service.abstractfactory;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 22:35 2018/1/15
 * @Modified by:
 */
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("this is a triangle");
    }
}
