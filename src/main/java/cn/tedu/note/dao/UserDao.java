package cn.tedu.note.dao;

import cn.tedu.note.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by mj on 2017/11/16.
 *
 */
@Service
public interface UserDao {

    void saveUser(User user);

    User findUserById(String id);

    User findUserByName(String name);

}
