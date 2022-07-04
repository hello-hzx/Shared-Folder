package com.atname.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 把map注入到Javabean中
 *
 * @author 1
 * @create 09-14
 */
public class WebUtils {
//    private static ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 从容器中获取组件
     * Servlet 是tomcat创建
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T>T getBean(Class<T> clazz) {
        // 获取ioc容器
        WebApplicationContext ioc = ContextLoader.getCurrentWebApplicationContext();
        return ioc.getBean(clazz);
    }
    /**
     *
     * @param value
     * @param bean
     * @param Map
     * @param <T>
     * @return
     */
    public static <T> T copyParamToBean(Map value, T bean) {

        try {
            // 调用的还是set读方法
            BeanUtils.populate(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * String 转 int
     * @param strInt
     * @param defaultVal
     * @return
     */
    public static int parseInt(String strInt, int defaultVal) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultVal;
    }

}
