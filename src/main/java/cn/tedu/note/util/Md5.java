package cn.tedu.note.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * Created by mj on 2017/11/16.
 */
public class Md5 {

    private static final String salt = "你吃了吗？";

    public static String crypt(String pwd){
        return DigestUtils.md5Hex(pwd+salt);
    }


}
