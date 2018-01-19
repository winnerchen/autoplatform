package yiheng.chen.cms.service.abstractfactory;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 22:36 2018/1/15
 * @Modified by:
 */
public class Blue  implements Color{
    @Override
    public void paint() {
        System.out.println("the color is blue");
    }
}
