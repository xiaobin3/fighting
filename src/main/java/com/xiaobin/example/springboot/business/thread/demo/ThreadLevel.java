package com.xiaobin.example.springboot.business.thread.demo;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/17
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 *
 * 线程的优先级别【1~10】1最不重要
 * 如果没有给线程设置优先级，则默认5级
 */
public class ThreadLevel {
    public static Object object = new Object();//类锁

    public static void main(String[] args){
        Thread thread1 = new Thread(new T1());
        Thread thread2 = new Thread(new T2());

        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        System.out.println("End===========================");
    }

    static class T1 implements Runnable{

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            synchronized (object){
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我得到T1-object的锁了！！！");
            }
        }
    }

    static class T2 implements Runnable{

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            synchronized (object){
                object.notify();
                System.out.println("T2解锁唤醒！！！");
            }
        }
    }
}
