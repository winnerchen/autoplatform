package yiheng.chen.cms.service.factorymethod;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 18:40 2018/1/15
 * @Modified by:
 */
public class ShapeFactoryCircle implements ShapeFactory {
    @Override
    public Shape getInstance() {
        return new Circle();
    }
}
