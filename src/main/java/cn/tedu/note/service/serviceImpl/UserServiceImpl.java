package cn.tedu.note.service.serviceImpl;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;
import cn.tedu.note.exception.PasswordException;
import cn.tedu.note.exception.UserNameException;
import cn.tedu.note.service.UserService;
import cn.tedu.note.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by mj on 2017/11/16.
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User login(String name, String password) throws UserNameException, PasswordException {
        //检验输入参数的合理性
        if(name==null){
            throw new UserNameException("名不能空");
        }
        String reg = "^\\w{3,10}$";
        if(! name.matches(reg)){
            throw new UserNameException("不合规");
        }
        if(password==null){
            throw new PasswordException("不能空");
        }
        if(! password.matches(reg)){
            throw new PasswordException("不合规");
        }
        //查询用户数据
        User user=userDao.findUserByName(name);
        if(user==null){
            throw new UserNameException("错误");
        }
        String psw = Md5.crypt(password);
        if(user.getPassword().equals(psw)){
            //业务处理
            //登录成功，返回用户信息
            return user;
        }
        throw new PasswordException("密码错");
    }

    public User regist(String name, String nick, String password, String confirm) throws UserNameException, PasswordException {
        if(name==null){
            throw new UserNameException("不能空");
        }
        String reg = "^\\w{3,10}$";
        if(! name.matches(reg)){
            throw new UserNameException("不合规则");
        }
        if(nick==null){
            nick = name;
        }
        if(password==null){
            throw new PasswordException("不能空");
        }
        password = password.trim();
        if(! password.matches(reg)){
            throw new UserNameException("密码不合规");
        }
        if(! password.equals(confirm)){
            throw new PasswordException("确认不一致");
        }
        name = name.trim();
        //检验用户名是否重复？
        User one=userDao.findUserByName(name);
        if(one!=null){
            throw new UserNameException("已注册");
        }
        // name, nick, password
        //UUID 用于生产永远不重复的ID
        String id= UUID.randomUUID().toString();
        String token="";
        String pwd=Md5.crypt(password);
        User user = new User(id, name, pwd, token, nick);
        userDao.saveUser(user);
        return user;

    }

}
