package yiheng.chen.cms.controller;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yiheng.chen.cms.service.UserService;
import yiheng.chen.common.util.EhCacheUtil;
import yiheng.chen.common.util.PropertiesFileUtil;

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

    private static Logger _log = LoggerFactory.getLogger(CacheController.class);

    private final static String EHCACHE_NAME = PropertiesFileUtil.getInstance().get("ehcache_name");

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public Object test(HttpServletRequest request) {
        System.out.println(System.getProperty("java.io.tmpdir"));
        return "success";
    }

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
        EhCacheUtil.put(EHCACHE_NAME, key, value);
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
        EhCacheUtil.remove(EHCACHE_NAME, key);
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
        Object object = EhCacheUtil.get(EHCACHE_NAME, key);
        if (null == object) {
            _log.debug("【Ehcache】没有找到key={}的记录！", key);
            return "value";
        }
        return object;
    }

    public static void main(String[] args) {

        // EhCache调用
        // Create a cache manager
        final CacheManager cacheManager = CacheManager.getInstance();
        // create the cache called "hello-world"
        final Cache cache = cacheManager.getCache("ehcache");
        // create a key to map the data to
        final String key = "key";
        // Create a data element
        final Element element = new Element(key, "value");
        // Put the element into the data store
        cache.put(element);
        // Retrieve the data element
        final Element cacheElement = cache.get(key);
        // Print the value
        System.out.println(cacheElement.getObjectValue());
    }

}