package multithread.test;

public class MessageRun implements Runnable{
    private String msg;
    private static int taskCount = 0;
    private final int currentCount = taskCount++;

    public MessageRun(String msg){
        this.msg = new String(msg);
        System.out.println("(" + currentCount + ")task start: " + msg);
    }
    public MessageRun(){

    }

    @Override
    public void run() {
        for(int i = 0 ; i < 3 ; i++){
            System.out.println("(" + currentCount + ")task is running (" + i + ")");
            Thread.yield();
        }
        System.out.println("(" + currentCount + ")task end: " + msg);
    }
}
