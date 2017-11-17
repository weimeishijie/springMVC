package cn.tedu.note.web;

import cn.tedu.note.entity.User;
import cn.tedu.note.exception.PasswordException;
import cn.tedu.note.exception.UserNameException;
import cn.tedu.note.service.UserService;
import cn.tedu.note.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by mj on 2017/11/16.
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult<User> login(String name, String password){
        User user = userService.login(name, password);
        return new JsonResult<User>(user);
    }

    @RequestMapping("/regist.do")
    @ResponseBody
    public JsonResult<User> regist(String name, String nick, String password, String confirm){
        User user = userService.regist(name, nick, password, confirm);
        return new JsonResult<User>(user);
    }


    @ExceptionHandler(UserNameException.class)
    @ResponseBody
    public JsonResult userName(UserNameException e){
        e.printStackTrace();
        return new JsonResult(2, e);
    }
    @ExceptionHandler(PasswordException.class)
    public JsonResult password(PasswordException e){
        e.printStackTrace();
        return new JsonResult(3, e);
    }
    @ExceptionHandler
    @ResponseBody
    public JsonResult exp(Exception e){
        e.printStackTrace();
        return new JsonResult(e);
    }



}
