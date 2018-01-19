package yiheng.chen.cms.service.abstractfactory;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 22:37 2018/1/15
 * @Modified by:
 */
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Shape createShape() {
        return new Triangle();
    }

    @Override
    public Color createColor() {
        return new Blue();
    }
}
