package com.cn.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Agent implements InvocationHandler {
    private Object obj;

    public Agent(Object obj) {
        this.obj = obj;
    }
    /*
    * invoke方法是JVM调用的
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        //得到本次要增强的方法的名称
        String methodName=method.getName();
        //日志输出
        System.out.println(DateUtil.now()+":"+methodName+"开始执行....");
        result=method.invoke(obj,args);
        System.out.println(DateUtil.now()+":"+methodName+"执行结束....");
        return result;
    }
    public Object getAgent(){
        Object xxx= Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),this);
        return xxx;
    }
}
