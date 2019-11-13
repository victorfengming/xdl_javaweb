package cn.xdl.dao.imp;

import cn.xdl.dao.BaseUserDao;
import cn.xdl.util.User29;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdl_javaweb
 * @package cn.xdl.dao.imp
 * @created 2019-11-13 19:02
 * @function ""
 */
public class UserDao_Oracle implements BaseUserDao {

    @Override
    public boolean insert(User29 u) {
        // 定义一堆儿空
        Connection conn = null;
        PreparedStatement state = null;
        //1. 获取连接对象
//        conn =
        //2. 预编译执行环境
        //3. 填充预编译中的参数(问号)
        //4. 执行,并根据执行时对数据库表格的影响行数,返回true
        return false;
    }

    @Override
    public boolean findByUsernameAndPassword(User29 u) {
        return false;
    }

    @Override
    public boolean updatePasswordByUsernameAndPassword(User29 oldUser, String newPass) {
        return false;
    }

    @Override
    public List<User29> findAll() {
        return null;
    }
}
