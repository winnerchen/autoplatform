package yiheng.chen.cms.service.abstractfactory;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 22:35 2018/1/15
 * @Modified by:
 */
public class Red implements Color {
    @Override
    public void paint() {
        System.out.println("the color is red");
    }
}
