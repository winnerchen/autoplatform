package yiheng.chen.cms.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Yiheng Chen
 * @Description: back end interceptor
 * @Date: Created in 13:34 2017/12/21
 * @Modified by:
 */
public class ManageInterceptor extends HandlerInterceptorAdapter {
    private static Logger _log = LoggerFactory.getLogger(ManageInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        _log.info("ManageInterceptor==>preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {

    }
}
