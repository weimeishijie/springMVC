package com.test.Md5;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mj on 2017/11/16.
 */
public class Md5test {

    ClassPathXmlApplicationContext ctx;
    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext(
                "spring-web.xml",
                "spring-mybatis.xml",
                "spring-service.xml");
    }
    @Test
    public void testMd5(){
        String str = "123";
        String md5 = DigestUtils.md5Hex(str);
        System.out.println(md5);
    }

    @Test
    public void testSaltPwd() throws Exception {
        String pwd = "123";
        String salt = "你吃了吗？";
        String s = DigestUtils.md5Hex(pwd+salt);
        System.out.println(s);
        //2625eadfbe7fa3168f8e9cafa28aaa44

        //update cn_user set cn_user_password =
        // '2625eadfbe7fa3168f8e9cafa28aaa44'
    }

}
