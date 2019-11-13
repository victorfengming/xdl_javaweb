package cn.xdl.servlet;

import cn.xdl.service.UserService;
import cn.xdl.util.User29;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdl_javaweb
 * @package ${PACKAGE_NAME}
 * @created 2019-11-13 21:25
 * @function ""
 */
@WebServlet("/reg.do")
public class RegServlet extends HttpServlet {
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
        boolean flag = UserService.reg(new User29(username, password));
        // 4. 根据service的返回值,响应不同的内容
        String resultHtml = null;
        if (flag) {
            // 注册成功
            resultHtml = "<h3>恭喜你,注册成功了<a href='login.html'></a></h3>";
        } else {
            // 注册失败
            resultHtml = "<h3>(*^▽^*)嘿嘿,注册成功了<a href='login.html'></a></h3>";
        }
        response.getWriter().append(resultHtml);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
