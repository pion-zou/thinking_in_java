package multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//public class ExplicitCirticalSection {
//    public static void main(String[] args){
//        PairManager pman1 = new ExplicitPairManager1(),
//        pman2 = new ExplicitPairManager2();
//        CriticalSection.testApproaches(pman1 , pman2);
//
//    }
//}
//
//class ExplicitPairManager1 extends PairManager{
//    private Lock lock = new ReentrantLock();
//
//    @Override
//    public synchronized void increment() {
//        lock.lock();
//        try{
//            p.incrementX();
//            p.incrementY();
//            store(getPair());
//        }finally {
//            lock.unlock();
//        }
//    }
//}
//class ExplicitPairManager2 extends PairManager{
//    private Lock lock = new ReentrantLock();
//
//    @Override
//    public void increment() {
//        Pair temp;
//        lock.lock();
//        try{
//            p.incrementY();
//            p.incrementX();
//            temp = getPair();
//        }finally {
//            lock.unlock();
//        }
//        store(temp);
//    }
//}

public class ExplicitCirticalSection {
    public static void main(String[] args) {
        CriticalSection.testApproaches(new ExplicitPairManager1(),
                new ExplicitPairManager2());
    }
}

class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();

    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }

}

class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}
