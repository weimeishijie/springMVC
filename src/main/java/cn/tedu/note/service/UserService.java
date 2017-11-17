package cn.tedu.note.service;

import cn.tedu.note.entity.User;
import cn.tedu.note.exception.PasswordException;
import cn.tedu.note.exception.UserNameException;
import org.springframework.stereotype.Service;

/**
 * Created by mj on 2017/11/16.
 *
 */
public interface UserService {

    User login(String name, String password) throws UserNameException, PasswordException;

    User regist(String name, String nick, String password, String confirm)
            throws UserNameException, PasswordException;


}
