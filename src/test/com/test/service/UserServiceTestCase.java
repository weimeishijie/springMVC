package com.test.service;

import cn.tedu.note.entity.User;
import cn.tedu.note.service.UserService;
import cn.tedu.note.service.serviceImpl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mj on 2017/11/16.
 *
 */
public class UserServiceTestCase {

    ClassPathXmlApplicationContext ctx;
    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext(
                "spring-web.xml",
                "spring-mybatis.xml",
                "spring-service.xml");
    }

    @Test
    public void testLogin(){
        UserService service=ctx.getBean("userService", UserService.class);
        String name="Tom";
        String password="123";
        User user = service.login(name, password);
        System.out.println(user);
    }

    @Test
    public void testRegistUser(){
        UserService service = ctx.getBean("userService", UserService.class);
        User user=service.regist("Jerry", "Mouse","123", "123");
        System.out.println(user);
    }




}
