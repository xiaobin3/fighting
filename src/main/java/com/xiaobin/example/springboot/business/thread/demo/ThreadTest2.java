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
 * ①集成java.lang.Thread
 * ②重写run()
 */
public class ThreadTest2 extends Thread {
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是ThreadTest2重写的run!======>" + i);
        }
    }
}
