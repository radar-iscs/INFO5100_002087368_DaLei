import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.math.BigInteger;

class PrimeTask implements Runnable {
    private final int position;

    public PrimeTask(int position) {
        this.position = position;
    }

    @Override
    public void run() {
        int num = getPrime();
        System.out.printf("[%s] the %d of Prime: %d (%s)\n", Thread.currentThread().getName(), position, num, java.time.LocalTime.now().toString());

        delay();
    }

    private int getPrime() {
        int count = 0;
        int num = 2;
        while (count < position) {
            if (isPrime(num)) {
                count++;
            }
            num++;
        }
        return num - 1;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void delay() {
        try {
            Thread.sleep((long) (Math.random() * 400 + 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FibonacciTask implements Runnable {
    private final int position;

    public FibonacciTask(int position) {
        this.position = position;
    }

    @Override
    public void run() {
        long num = getFibonacci();
        System.out.printf("[%s] the %d of Fibonacci: %d (%s)\n", Thread.currentThread().getName(), position, num, java.time.LocalTime.now().toString());

        delay();
    }

    private long getFibonacci() {
        if (position == 1 || position == 2) {
            return 1;
        }

        long a1 = 1, a2 = 1;
        for (int i = 3; i <= position; i++) {
            long next = a1 + a2;
            a1 = a2;
            a2 = next;
        }
        return a2;
    }

    private void delay() {
        try {
            Thread.sleep((long) (Math.random() * 400 + 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FactorialTask implements Runnable {
    private final int position;

    public FactorialTask(int position) {
        this.position = position;
    }

    @Override
    public void run() {
        BigInteger num = getFactorial();
        System.out.printf("[%s] the %d of Factorial: %d (%s)\n", Thread.currentThread().getName(), position, num, java.time.LocalTime.now().toString());

        delay();
    }

    private BigInteger getFactorial() {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= position; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    private void delay() {
        try {
            Thread.sleep((long) (Math.random() * 400 + 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

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
