package yiheng.chen.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yiheng.chen.common.util.EhCacheUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 10:32 2017/12/18
 * @Modified by:
 */
@Controller
@RequestMapping("/cache")
public class CacheController {

    private static Logger logger = LoggerFactory.getLogger(CacheController.class);

    private final static String CACHE_NAME = "ehcache_common";

    /**
     * 新增缓存记录
     * @param request
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(HttpServletRequest request) {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        EhCacheUtil.put(CACHE_NAME, key, value);
        return "success";
    }

    /**
     * 删除缓存记录
     * @param request
     * @return
     */
    @RequestMapping("/remove")
    @ResponseBody
    public Object remove(HttpServletRequest request) {
        String key = request.getParameter("key");
        EhCacheUtil.remove(CACHE_NAME, key);
        return "success";
    }

    /**
     * 获取缓存记录
     * @param request
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public Object get(HttpServletRequest request) {
        String key = request.getParameter("key");
        Object object = EhCacheUtil.get(CACHE_NAME, key);
        if (null == object) {
            logger.debug("【Ehcache】没有找到key={}的记录！", key);
            return "value";
        }
        return object;
    }

}