package com.xiaobin.example.springboot.business.thread.demo;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/19
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 *
 *  * 线程的同步（协同）
 * 同步的概念
 * 同步的原因
 * 	 为了数据安全
 * 同步的条件
 * 1.多线程
 * 2.共享同一数据
 * 3.数据涉及到修改操作
 *
 * 实现同步的方法
 * 1.用同步方法实现
 * 2.用同步代码块实现
 */
public class TestSynchronized {
    public static void main(String[] args) {

//        test();

    }

    public static void test1() {
        TestSynchronized th = new TestSynchronized();
        th.useThread();
    }
    public void test() {
        TestSynchronized th = new TestSynchronized();
        th.useThread();
    }

    public void useThread(){

        Bank bank = new Bank();
        Card card = new Card(bank);

        Thread t1 = new Thread(card);

        t1.start();

        Thread t2 = new Thread(card);

        t2.start();
    }


    class Bank{

        //存款额
        private int acc = 100;

        public int getAcc(){
            return acc;
        }

        //存款
        public synchronized void save(int money){
            //把整个方法都同步了
            acc += money;
            //代码1...
            //代码2...
        }

        public  void save1(int money){

            synchronized(this){
                //只同步需要同步的
                acc += money;
            }

            //代码1...
            //代码2...

        }
    }


    class Card implements Runnable{

        private Bank bank;

        public Card(Bank bank){
            this.bank = bank;
        }

        @Override
        public void run() {

            for(int i=0;i<10;i++){
                bank.save(10);
                System.out.println(i+"账户余额为"+bank.getAcc());
            }

        }

    }
}
