package cn.xdl.servlet;


import cn.xdl.service.UserService;
import cn.xdl.util.User29;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdl_javaweb
 * @package cn.xdl.servlet
 * @created 2019-11-13 21:25
 * @function ""
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // MVC 这里是Control层,传说中的调度层,
        // 我们拿到数据不需要进行处理,传递给别人,就可以了
        // 0. 修改编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 告诉服务器,这个是HTML
        response.setContentType("text/html;charset=utf-8");
        // TODO
        // 1. 接收账号
        String username = request.getParameter("username");
        // 2. 接收密码
        String password = request.getParameter("password");
        // 3. 将账号密码传递给service
        boolean flag = UserService.login(new User29(username, password));
        // 4. 根据service的返回值,响应不同的内容
        String resultHtml = null;
        if (flag) {
            // 登录成功
            resultHtml = html(username);
        } else {
            // 登录失败
            resultHtml = "<h3>(*^▽^*)嘿嘿,登录成功了<a href='login.html'></a></h3>";
        }
        response.getWriter().append(resultHtml);
    }

    private String html(String username) {
        // 显示用户的所有数据
        List<User29> data = UserService.findAll();
        StringBuilder sb = new StringBuilder();
        sb.append("<div><span>欢迎你,sivp用户:"+username+"</span><a href='update.html'>修改密码</a></div>");
        sb.append("<table>");
        sb.append("<tr><th>用户编号</th><th>用户账号</th><th>用户密码</th></tr>");
        // 来个for遍历往里面追加
        for (User29 u : data) {
            sb.append("<tr><td>"+u.getId()+"</td><td>"+u.getUsername()+"</td><td>"+u.getPassword()+"</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();

    }

}
