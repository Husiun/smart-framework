package org.smart4xy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * mvc核心类
 * 请求转发器
 * Created by issuser on 2017/10/14.
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
    //初始化
    @Override
    public void init() throws ServletException {
        HelperLoader.init();//初始化helper相关的类

    }
}
