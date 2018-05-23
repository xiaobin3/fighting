package com.xiaobin.example.springboot.business.classforname.demo;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/21
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */

public class ClassForName {
    public static void main(String[] args) throws Exception {
        Class outerClass = Class.forName("com.xiaobin.example.springboot.business.classforname.demo.OuterClass");
        //通过外部类的方法名获取外部类的方法
        Method method = outerClass.getDeclaredMethod("func");
        //调用外部类实例的func方法，invoke第一参数为外部类实例
        method.invoke(outerClass.newInstance());
        //内部类反射名字需要使用$分隔，编译后生成的规则
        Class innerClass = Class.forName("com.xiaobin.example.springboot.business.classforname.demo.OuterClass$InnerClass");
        //通过内部类的方法名获取内部类的方法
        Method method2 = innerClass.getDeclaredMethod("getName");
        //特别注意!!!!内部类newInstance的第一个参数必须是外部类实例的引用
        method2.invoke(innerClass.getDeclaredConstructors()[0].newInstance(outerClass.newInstance(), "yan"));

        System.out.println("===========================");
        Class<?> threadClass = Class.forName("com.xiaobin.example.springboot.business.thread.demo.TestSynchronized");
        Method main = threadClass.getDeclaredMethod("test");
        main.invoke(threadClass.newInstance());
        System.out.println("===========================");
        Thread.sleep(1000);
        Method main1 = threadClass.getDeclaredMethod("test1");
        main1.invoke(threadClass.newInstance());
    }
}

class OuterClass {
    public void func() {
        System.out.println("Outer class.");
    }

    class InnerClass {
        private String mName;

        public InnerClass(String name) {
            mName = name;
        }

        void getName() {
            System.out.println("name is:" + mName);
        }
    }
}