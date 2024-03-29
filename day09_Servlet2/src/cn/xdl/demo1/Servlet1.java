package cn.xdl.demo1;

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
 * @package cn.xdl.demo1
 * @created 2019-11-15 13:30
 * @function "线程锁测试"
 */
@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
    // 剩余票数
    private int count = 10;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建线程锁对象,用于作为标记
        Object ob = new Object();
        // 这个地方写什么对象都行,别瞎传递就行!
        synchronized (ob) {
            if (count > 0) {
                System.out.println("恭喜你,有票");
                System.out.println("正在出票");
                count--;
                System.out.println("出票完成,剩余票数:" + count);
            } else {
                System.out.println("很遗憾,没票了!");
            }
        }
    }
}
