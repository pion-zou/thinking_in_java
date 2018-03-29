package multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed(){
        boolean captured = lock.tryLock();
        try{
            System.out.println("tryLock(): " + captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }

    public void timed(){
        boolean captured = false;
        try{
            captured = lock.tryLock(2 , TimeUnit.SECONDS);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        try{
            System.out.println("tryLock(2 , TimeUnit.SECONDS): " + captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread(){
            {setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.sleep(1000);
//        Thread.yield();

        al.untimed();
        al.timed();
    }

    //以下代码为网上摘抄

//    //可重入的互斥锁
//    private ReentrantLock lock=new ReentrantLock();
//    public void untimed()//不计时的
//    {
//        // 仅在调用时锁未被另一个线程保持的情况下，才获取该锁。
//        boolean captured=lock.tryLock();
//        try
//        {
//            System.out.println("tryLock(): "+captured);
//        } finally
//        {
//            if(captured)
//                lock.unlock();
//        }
//    }
//
//    /////////////
//    public void timed()//计时
//    {
//        boolean captured=false;
//        try {
//            //如果锁在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁。
//            captured=lock.tryLock(2,TimeUnit.SECONDS);
//        } catch(InterruptedException e)
//        {
//            throw new RuntimeException(e);
//        }
//
//        try
//        {
//            System.out.println("tryLock(2,TimeUnit.SECONDS)  : "+captured);
//        } finally
//        {
//            if(captured)
//                lock.unlock();
//        }
//    }
//    ///////////////main
//    public static void main(String[] args) throws InterruptedException {
//        final AttemptLocking al=new AttemptLocking();
//        al.untimed();//true -- lock is available 锁可用
//        al.timed();//true -- lock is available
//        //现在创建一个单独的任务获取锁   使下面的线程调用产生竞争
//        new Thread()
//        {
//            {setDaemon(true);}
//            @Override
//            public void run() {
//                al.lock.lock();
//                System.out.println("acquired");
//            }
//        }.start();
//        Thread.sleep(1000);
//        // 暂停当前正在执行的线程对象，并执行其他线程。
////        Thread.yield();//give the 2nd task a chance 给第二个任务一个机会
//        al.untimed();//false--lock grabbed by task 锁了的任务
//        al.timed();//false--lock grabbed by task
//    }
}
