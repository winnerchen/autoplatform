package yiheng.chen.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 22:34 2017/12/21
 * @Modified by:
 */
@Controller
@RequestMapping("/manage")
public class ManageController {

    private static Logger _log = LoggerFactory.getLogger(ManageController.class);

    @RequestMapping(value = {"", "/index"})
    @ResponseBody
    public Object index() {
        return "/manage/index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object login() {
        return "/manage/login";
    }

}

