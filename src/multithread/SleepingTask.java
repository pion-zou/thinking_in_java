package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try{
            while (countDown-- > 0){
                System.out.print(status());
                //对毫秒进行包装
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 5 ; i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
