package multithread.test;

public class MoreBasicThreads1 {
    public static void main(String[] args){
        for(int i = 0 ; i < 10 ; i++){
            new Thread(new MessageRun("nihao")).start();
        }
    }
}
