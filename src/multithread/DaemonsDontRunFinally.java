package multithread;

import java.util.concurrent.TimeUnit;

public class DaemonsDontRunFinally {
    public static void main(String[] args){
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}

class ADaemon implements Runnable{

    @Override
    public void run() {
        try{
            println("Starting Daemon");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            println("Exiting via InterruptedExcrption");
        }
        finally {
            println("This should always run?");
        }

    }

    public static void println(String msg){
        System.out.println(msg);
    }
}
