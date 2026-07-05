import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

public class VirtualThreadsVsPlatformThreads {

    static void main() throws InterruptedException {

        Runnable printThread = () -> System.out.println(Thread.currentThread());

        Thread.Builder.OfVirtual n=Thread.ofVirtual();
        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        ThreadFactory kernelThreadFactory = Thread.ofPlatform().factory();

        Thread virtualThread = virtualThreadFactory.newThread(printThread);
        Thread kernelThread = kernelThreadFactory.newThread(printThread);

        virtualThread.start();
        kernelThread.start();
        n.start(()->IO.println("Hello! Thread Created using Builder"));

        virtualThread.join();
        kernelThread.join();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                System.out.println("Running inside: " + Thread.currentThread());
            });
        }

        final ScopedValue<String> USER_ID = ScopedValue.newInstance();
        ScopedValue.where(USER_ID, "UmaMahesh").run(() -> {
            System.out.println("Processing request for: " + USER_ID.get());
        });

        //Creating 1 million threads
        IntStream.range(0, 1_000_000).forEach(i -> {
            Thread.ofVirtual().start(() -> {
                System.out.println("Hello from " + Thread.currentThread());
            });
        });
    }
}
