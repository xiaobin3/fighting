package com.xiaobin.example.springboot.business.classforname.demo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/23
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
public class ClassLoaderTest {
    public static void main(String[] args){
        //输出ClassLoaderText的类加载器名称
        System.out.println("ClassLoaderText类的加载器的名称:"+ClassLoaderTest.class.getClassLoader().getClass().getName());
        System.out.println("System类的加载器的名称:"+System.class.getClassLoader());
        System.out.println("List类的加载器的名称:"+List.class.getClassLoader());
        System.out.println("ClassForName类的加载器的名称:"+ClassForName.class.getClassLoader());

        ClassLoader cl = ClassLoaderTest.class.getClassLoader();
        while(cl != null){
            System.out.print(cl.getClass().getName()+"->");
            cl = cl.getParent();
        }
        System.out.println(cl);
    }
}
