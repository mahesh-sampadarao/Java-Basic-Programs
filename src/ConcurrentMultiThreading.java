import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class CustomThread extends Thread implements Runnable {

    @Override
    public void run() {

        System.out.println("This is a custom thread created for : "+this.getClass().descriptorString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ConcurrentMultiThreading {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final Lock lock=new ReentrantLock();
        final ReadWriteLock lock2 = new ReentrantReadWriteLock();

        Thread t1=new Thread(new CustomThread());
        System.out.println(t1.getState()); // NEW
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE
        Thread.sleep(100);
        System.out.println(t1.getState()); // TIMED_WAITING
        t1.join();
        System.out.println(t1.getState()); // TERMINATED

        ExecutorService es= Executors.newSingleThreadExecutor();
        Future<?> submit = es.submit(() -> System.out.println("Hello!"));
        Future<String> future=es.submit(()->"Hello!");
        System.out.println(future.get());
        System.out.println(submit.get());
        if(submit.isDone()){
            System.out.println("Task is done!");
        }

        es.shutdown();
        if(es.isShutdown()){
            System.out.println("Thread has been shutdown!");
        }

    }
}
