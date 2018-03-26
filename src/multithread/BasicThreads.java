package multithread;

public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.print("waiting for lift off\n");
    }
}
