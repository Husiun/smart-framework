package org.smart4xy;

import org.apache.commons.lang3.StringUtils;
import org.smart4xy.bean.Data;
import org.smart4xy.bean.Handler;
import org.smart4xy.bean.Param;
import org.smart4xy.bean.View;
import org.smart4xy.helper.BeanHelper;
import org.smart4xy.helper.ConfigHelper;
import org.smart4xy.helper.ControllerHelper;
import org.smart4xy.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * mvc核心类
 * 请求转发器
 * Created by issuser on 2017/10/14.
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
    //初始化
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        HelperLoader.init();//初始化helper相关的类
        //获取ServletContext,用于注册servlet
        ServletContext servletContext = servletConfig.getServletContext();
        //注册处理jsp的servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        //注册处理静态资源默认的servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法和请求路劲
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        //获取handler,action处理器
        Handler handler = ControllerHelper.getHandler(requestMethod,requestPath);
        if(handler != null){
            //获取controller类
            Class<?> controllerClass = handler.getControllerClass();
            //根据类获取对应的实例
            Object controllerBean = BeanHelper.getBean(controllerClass);
            //创建请求参数对象
            Map<String,Object> paramMap = new HashMap<String, Object>();
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()){
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName,paramValue);
            }
            String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
            if(StringUtils.isNotEmpty(body)){
                String[] params = StringUtils.split(body,"&");
                if(ArrayUtil.isNotEmpty(params)){
                    for(String param:params){
                        String[] array = StringUtils.split(param,"=");
                        if(ArrayUtil.isNotEmpty(array)&&array.length == 2){
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName,paramValue);
                        }
                    }
                }
            }

            Param param = new Param(paramMap);
            //调用action 方法
            Method actionMethod = handler.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean,actionMethod,param);
            //处理action方法返回值
            if(result instanceof View){
                View view = (View)result;
                String viewPath = view.getPath();
                if(StringUtils.isNotEmpty(viewPath)){
                    if(viewPath.startsWith("/")){
                        resp.sendRedirect(req.getContextPath()+viewPath);
                    }else{
                       Map<String,Object> modelMap = view.getModel();
                        for(Map.Entry<String,Object> mapEntry:modelMap.entrySet()){
                            req.setAttribute(mapEntry.getKey(),mapEntry.getValue());
                        }
                        req.getRequestDispatcher(ConfigHelper.getAppJspPath()+viewPath).forward(req,resp);
                    }

                }
            }else if(result instanceof Data){
                //返回json数据
                Data data = (Data)result;
                Object model = data.getModel();
                if(model != null){
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter writer = resp.getWriter();
                    String json = JsonUtil.toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }
        }
    }

}
