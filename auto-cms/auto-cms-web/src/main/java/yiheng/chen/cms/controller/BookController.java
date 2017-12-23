package yiheng.chen.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yiheng.chen.cms.dao.mapper.BookMapper;
import yiheng.chen.cms.dao.model.Book;
import yiheng.chen.cms.dao.model.BookExample;
import yiheng.chen.cms.dao.model.UserVO;
import yiheng.chen.cms.service.UserService;

import java.util.List;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 15:17 2017/12/17
 * @Modified by:
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BookMapper bookMapper;

    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        e.printStackTrace();
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String list(@PathVariable int id, Model model) {
        UserVO userVO = userService.selectUserWithBook(id);
        List<Book> books = userVO.getBooks();
        model.addAttribute("books", books);
        return "/book/list";

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listBook(Model model) {
        BookExample bookExample = new BookExample();
        List<Book> books = bookMapper.selectByExample(bookExample);
        model.addAttribute("books", books);
        return "/book/list";

    }
}
