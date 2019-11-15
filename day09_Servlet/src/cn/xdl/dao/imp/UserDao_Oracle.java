package cn.xdl.dao.imp;

import cn.xdl.dao.BaseUserDao;
import cn.xdl.util.DBCPUtil;
import cn.xdl.util.User29;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

    // 建议把所有的sql语句变成大写的,
    // 要是你写小写的,
    // 他执行之前还是要帮你转换成为大写的
    // 所以还是c+w->c+s+u好用
    // 这样可以节省性能
    // 要是有* 更加的可怕,他会全展开*在进行操作
    private static final String SQL_INSERT = "INSERT INTO USER28 VALUES(ID.NEXTVAL,?,?)";
//    private static final String SQL_INSERT = "INSERT INTO USER29 VALUES(5,?,?)";
    private static final String SQL_UPDATE = "UPDATE USER28 SET PASSWORD=? WHERE USERNAME=?AND PASSWORD=?";
    private static final String SQL_FIND_BY_USERNAME_AND_PASSWORD = "SELECT ID FROM USER28 WHERE USERNAME=?AND PASSWORD=?";
    private static final String SQL_FIND_ALL = "SELECT * FROM USER28";

    @Override
    public boolean insert(User29 u) {
        // 定义一堆儿空
        Connection conn = null;
        PreparedStatement state = null;
        try {
            //1. 获取连接对象
            conn = DBCPUtil.getConnection();
            //2. 预编译执行环境
            state = conn.prepareStatement(SQL_INSERT);
            //3. 填充预编译中的参数(问号)
            state.setString(1,u.getUsername());
            state.setString(2,u.getPassword());
            // System.out.println(SQL_INSERT);
            // TODO 这里有瑕疵,序列问题
            //4. 执行,并根据执行时对数据库表格的影响行数,返回true
            boolean res = state.executeUpdate() > 0;
//            System.out.println("结果是:"+res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean findByUsernameAndPassword(User29 u) {
        // 定义一堆儿空
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            //1. 获取连接对象
            conn = DBCPUtil.getConnection();
            //2. 预编译执行环境
            state = conn.prepareStatement(SQL_FIND_BY_USERNAME_AND_PASSWORD);
            //3. 填充预编译中的参数(问号)
            state.setString(1,u.getUsername());
            state.setString(2,u.getPassword());
            //4. 执行,并根据执行时对数据库表格的影响行数,返回true
            result = state.executeQuery();
            // 如果结果集中的游标能够下移,表示查询到了一行数据
            // 返回的就是next,
            return result.next();
            // 这里不用while循环,因为查到了还是没查到,
            // 这个是我登录逻辑关心的
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePasswordByUsernameAndPassword(User29 oldUser, String newPass) {
        // 定义一堆儿空
        Connection conn = null;
        PreparedStatement state = null;
        try {
            //1. 获取连接对象
            conn = DBCPUtil.getConnection();
            //2. 预编译执行环境
            state = conn.prepareStatement(SQL_UPDATE);
            //3. 填充预编译中的参数(问号)
            state.setString(1,newPass);
            state.setString(2,oldUser.getUsername());
            state.setString(3,oldUser.getPassword());
            //4. 执行,并根据执行时对数据库表格的影响行数,返回true
            return state.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User29> findAll() {
        // 先准备好一个容器
        ArrayList<User29> data = new ArrayList<>();
        // 这样在最后返回它,就不可能出现返回空的情况了
        // ,避免空指针异常

        // 定义一堆儿空先
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            //1. 获取连接对象
            conn = DBCPUtil.getConnection();
            //2. 预编译执行环境
            state = conn.prepareStatement(SQL_FIND_ALL);
            //3.  执行,并根据执行时对数据库表格的影响行数,返回true
            result = state.executeQuery();
            // 4. 遍历结果集,取出一行一行的数据
            while (result.next()) {
                //如果游标能向下移动就走你
                int id = result.getInt("id");
                String username = result.getString("username");
                String password = result.getString("password");
                data.add(new User29(id, username, password));
            }
            // ,并返回
        } catch (Exception e) {
            e.printStackTrace();
        }
        //爱咋地咋地,我还是return 这个 data
        return data;
    }
}
