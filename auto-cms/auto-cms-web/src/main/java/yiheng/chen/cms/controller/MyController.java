package yiheng.chen.cms.controller;

import yiheng.chen.common.util.PropertiesFileUtil;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 11:29 2017/12/21
 * @Modified by:
 */
public class MyController {
    private final static String EHCACHE_NAME = PropertiesFileUtil.getInstance().get("ehcache_name");

    public static void main(String[] args) {
        System.out.println(EHCACHE_NAME);
    }
}
