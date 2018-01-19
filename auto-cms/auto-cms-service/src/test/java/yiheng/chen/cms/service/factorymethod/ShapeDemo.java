package yiheng.chen.cms.service.factorymethod;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 22:16 2018/1/15
 * @Modified by:
 */
public class ShapeDemo {
    public static void main(String[] args) {
        Shape circle = new ShapeFactoryCircle().getInstance();
        Shape triangle = new ShapeFactoryTriangle().getInstance();

        circle.draw();
        triangle.draw();

    }
}
