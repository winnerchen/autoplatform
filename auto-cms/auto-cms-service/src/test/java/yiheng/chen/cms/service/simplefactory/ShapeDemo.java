package yiheng.chen.cms.service.simplefactory;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 18:34 2018/1/15
 * @Modified by:
 */
public class ShapeDemo {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.GetInstance("circle");
        shape.draw();
        Shape shape2 = ShapeFactory.GetInstance("triangle");
        shape2.draw();

    }
}
