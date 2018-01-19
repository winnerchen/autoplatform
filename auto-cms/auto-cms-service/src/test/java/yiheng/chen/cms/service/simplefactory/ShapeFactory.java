package yiheng.chen.cms.service.simplefactory;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 18:32 2018/1/15
 * @Modified by:
 */
public class ShapeFactory {
    public static Shape GetInstance(String shape) {
        if (shape.equals("circle")) {
            return new Circle();
        }
        if (shape.equals("triangle")) {
            return new Triangle();
        }
        return null;
    }
}
