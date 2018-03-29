package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CaptureUncaughtException {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
//        exec.execute(new ExceptionThread2());

    }
}

class ExceptionThread2 implements Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh2 = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Thead be caught = " + t);
        System.out.println("caught " + e);
    }
}
class HandlerThreadFactory implements ThreadFactory{
    private static int time = 0;

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread ,times = " + time++);
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh1 = " + t.getUncaughtExceptionHandler());
        return t;
    }
}
