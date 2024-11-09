import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainB {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 25; i++) {
            executor.submit(new PrimeTask(i));
        }

        for (int i = 1; i <= 50; i++) {
            executor.submit(new FibonacciTask(i));
        }

        for (int i = 1; i <= 50; i++) {
            executor.submit(new FactorialTask(i));
        }

        executor.shutdown();
    }
}
