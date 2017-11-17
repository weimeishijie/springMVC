package com.test.dao;

import cn.tedu.note.dao.NotebookDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by mj on 2017/11/16.
 */
public class NotebookMapper {

    ClassPathXmlApplicationContext ctx;

    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext(
                "spring-web.xml",
                "spring-mybatis.xml",
                "spring-service.xml");
    }

    @Test
    public void testFindNotebookByUserId(){
        //select cn_user_id
        // from cn_notebook;
        String userId="Tom";
        NotebookDao dao = ctx.getBean("notebookDao", NotebookDao.class);
        List<Map<String, Object>> list= dao.findNotebookByUserId(userId);
        for (Map<String, Object> n : list) {
            System.out.println(n);
        }
    }

}
