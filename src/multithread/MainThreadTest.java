package multithread;

public class MainThreadTest {
    public static void main(String[] args) throws InterruptedException {
        JoinThread t = new JoinThread();
        t.start();
        t.join();
//        t.interrupt();
        System.out.println("this is main thread");
    }
}
