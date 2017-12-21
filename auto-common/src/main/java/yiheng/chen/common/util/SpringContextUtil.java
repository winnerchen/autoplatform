package yiheng.chen.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 22:07 2017/12/21
 * @Modified by:
 */
public class SpringContextUtil implements ApplicationContextAware {

    public static SpringContextUtil springContextUtil = new SpringContextUtil();

    private static ApplicationContext context = null;

    public final static synchronized SpringContextUtil getInstance() {
        return springContextUtil;
    }

    private SpringContextUtil() {
        super();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }

    public static Object getBean(String name) {
        return context.getBean(name);

    }
}
