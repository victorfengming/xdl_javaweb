package cn.xdl.dao;

import cn.xdl.util.User29;
import sun.security.util.Password;

import java.util.List;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdl_javaweb
 * @package cn.xdl.dao
 * @created 2019-11-13 18:47
 * @function "面向抽象"
 */
public interface BaseUserDao {
    /**
     * 用于向数据库中user29表格 插入一行数据
     * @param u 要插入数据包含username和password属性
     * @return 插入的结果,true表示成功,false表示失败
     */
    boolean insert(User29 u);

    /**
     * 用于从数据库中查询一个数据是否存在
     * @param u 要查询的数据,包含username和password属性
     * @return 查询的结果,存在则为true
     */
    boolean findByUsernameAndPassword(User29 u);

    // 不要嫌长,力求语义表达清楚

    /**
     * 用于修改数据库中user29表格的password数据
     * @param oldUser 旧的数据,包含了账号和原密码
     * @param newPass 新密码
     * @return 修改的结果 true表示修改成功
     */
    boolean updatePasswordByUsernameAndPassword(User29 oldUser, String newPass);

    /**
     * 用于查询数据库中user29表的所有的数据了
     * @return 查询的所有的数据组成的list集合
     */
    List<User29> findAll();
}
