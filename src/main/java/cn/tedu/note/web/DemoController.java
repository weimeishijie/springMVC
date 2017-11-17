package cn.tedu.note.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mj on 2017/11/16.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hello.do")
    @ResponseBody
    public Object hello(){
        return new String[]{"Hello", "World!"};
    }

}
