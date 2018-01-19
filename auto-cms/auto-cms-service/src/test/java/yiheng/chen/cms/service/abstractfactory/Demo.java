package yiheng.chen.cms.service.abstractfactory;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 22:38 2018/1/15
 * @Modified by:
 */
public class Demo {
    public static void main(String[] args) {
        ConcreteFactory1 concreteFactory1 = new ConcreteFactory1();

        Color color = concreteFactory1.createColor();
        color.paint();

        Shape shape = concreteFactory1.createShape();
        shape.draw();

    }
}
