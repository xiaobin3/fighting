package com.xiaobin.example.springboot.business.thread.demo;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/16
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 * 第一种：①继承java.lang.Thread
 *        ②重写run()
 *  第二种：①实现Runnable[推荐，优势：单继承，多实现]
 *        ②重写run()
 *
 */
public class ThreadTest {
    public static void main(String[] args) {

        ThreadTest1 threadTest1 = new ThreadTest1();
        ThreadTest2 threadTest2 = new ThreadTest2();
        ThreadTest3 threadTest3 = new ThreadTest3();

        ThreadTest4 threadTest4 = new ThreadTest4();
        Thread thread = new Thread(threadTest4);


//        threadTest1.run();
        threadTest1.start();
        threadTest2.start();
        threadTest3.start();

        thread.start();

        for (int i = 0; i <= 10; i++) {
            System.out.println("main========>"+i);
        }
        System.out.println("END======================");
    }
}
