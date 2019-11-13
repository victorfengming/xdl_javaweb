package cn.xdl.service;

import cn.xdl.dao.BaseUserDao;
import cn.xdl.dao.imp.UserDao_Oracle;
import cn.xdl.util.User29;

import java.util.List;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdl_javaweb
 * @package cn.xdl.dao
 * @created 2019-11-13 21:08
 * @function ""
 */
public class UserService {
    private static BaseUserDao dao = new UserDao_Oracle();

    /**
     * 注册
     * @param u 注册账号密码
     * @return 注册的结果,true成功
     */
    public static boolean reg(User29 u) {
        return dao.insert(u);
    }

    /**
     * 登录
     * @param u 登录的账号密码
     * @return 登录的结果
     */
    public static boolean login(User29 u) {
        return dao.findByUsernameAndPassword(u);
    }

    /**
     * 修改密码
     * @param username 账号
     * @param oldPass 旧密码
     * @param newPass 新密码
     * @return 修改的结果true成功
     */
    public static boolean updatePassword(String username,String oldPass, String newPass) {
        return dao.updatePasswordByUsernameAndPassword(new User29(username, oldPass), newPass);

    }

    /**
     * 查询所有的用户
     * @return
     */
    public static List<User29> findAll() {
        return dao.findAll();
    }
}
