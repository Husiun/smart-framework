package org.smart4xy.helper;

        import org.apache.commons.collections4.CollectionUtils;
        import org.smart4xy.annotation.Action;
        import org.smart4xy.bean.Handler;
        import org.smart4xy.bean.Request;
        import org.smart4xy.util.ArrayUtil;

        import java.lang.reflect.Method;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Set;

/**
 * controller助手类，将请求request和handler封装为map
 * 首先从classHelper里面获取controller类，在进行遍历set集合，
 * 获取每一个类的所有带有action注解的方法，action.value获取mapping,从mapping获取
 * URL映射规则，//w+:\//w*正则表达式，获取以后截取为数组，再用request封装请求方法和请求路劲
 * 最后将整个放入前面定义的map里面
 * Created by issuser on 2017/10/14.
 */
public final class ControllerHelper {
    //封装请求和处理的map
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request,Handler>();

    static{
        Set<Class<?>> controllerSet = ClassHelper.getControllerClassSet();//获取controller类
        if(CollectionUtils.isNotEmpty(controllerSet)){
            //进行遍历
            for(Class<?> controllerClass:controllerSet){
                //获取类里面所有的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    //遍历类里面的所有方法
                    for(Method method:methods){
                        //对只有注解是action的进行处理
                        if(method.isAnnotationPresent(Action.class)){
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();//获取对应的规则
                            if(mapping.matches("\\w+:/\\w*")){//验证规则,比如"get:/***"
                                String[] requestqString = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(requestqString)&&requestqString.length == 2){
                                    String requestMethod = requestqString[0];
                                    String requestPath = requestqString[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    Handler handler = new Handler(controllerClass,method);
                                    //初始化map
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }

}
