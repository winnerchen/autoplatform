package yiheng.chen.cms.service.factorymethod;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 18:39 2018/1/15
 * @Modified by:
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("this is a circle");
    }
}
