package multithread;

import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;
import net.mindview.util.Print;

public class Joining {
    public static void main(String[] args){
        Sleeper sleepy = new Sleeper("Sleep" , 3000),
                grumpy = new Sleeper("Grumpy" , 3000);
        grumpy.interrupt();
        Joiner dopey = new Joiner("Dopey" , sleepy) ,
                doc = new Joiner("Doc", grumpy);


    }

}

class Sleeper extends Thread{
    private int duration;

    public Sleeper( String name ,int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try{
            sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName() + " was interrupted. " + "is Interrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;

    public Joiner(String name , Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try{
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
