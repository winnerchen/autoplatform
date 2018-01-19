package yiheng.chen.cms.service.factorymethod;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 18:41 2018/1/15
 * @Modified by:
 */
public class ShapeFactoryTriangle implements ShapeFactory{
    @Override
    public Shape getInstance() {
        return new Triangle();
    }
}
