package cn.xdl.servlet;


import cn.xdl.service.UserService;

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
 * @package cn.xdl.servlet
 * @created 2019-11-13 21:25
 * @function ""
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // MVC 这里是Control层,传说中的调度层,
        // 我们拿到数据不需要进行处理,传递给别人,就可以了
        // 0. 修改编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 告诉服务器,这个是HTML
        response.setContentType("text/html;charset=utf-8");
        // 1. 接收账号
        String username = request.getParameter("username");
        // 2. 接收密码
        String[] passwords = request.getParameterValues("password");
        // 3. 将账号密码传递给service
        boolean flag = UserService.updatePassword(username, passwords[0], passwords[1]);
        // 4. 根据service的返回值,响应不同的内容
        String resultHtml = null;
        if (flag) {
            // 登录成功
            resultHtml = "修改成功了,<a href='login.html'>点击登录</a>";
        } else {
            // 登录失败
            resultHtml = "<h3>(*^▽^*)修改失败了<a href='login.html'>点击登录</a></h3>";
        }
        response.getWriter().append(resultHtml);
    }


}
