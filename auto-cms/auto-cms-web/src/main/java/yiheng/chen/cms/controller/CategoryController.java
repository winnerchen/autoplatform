package yiheng.chen.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yiheng.chen.cms.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 10:58 2017/12/18
 * @Modified by:
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private UserService userService;

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = {""})
    public String index() {
        return "redirect:/category/list";
    }

    /**
     * 列表
     * @param page
     * @param rows
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "20") int rows,
            HttpServletRequest request) {

        return "/category/list";
    }

}
