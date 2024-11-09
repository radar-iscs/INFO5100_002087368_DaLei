import java.math.BigInteger;

class PrimeThread extends Thread {
    public void run() {
        System.out.printf("[%s] Prime thread starts (%s)\n", getName(), java.time.LocalTime.now().toString());

        int count = 1;
        int num = 2;
        while (count <= 25) {
            if (isPrime(num)) {
                System.out.printf("[%s] the %d of Prime: %d (%s)\n", getName(), count, num, java.time.LocalTime.now().toString());

                count++;
                delay();
            }
            num++;
        }
        System.out.printf("[%s] Prime thread ends (%s)\n", getName(), java.time.LocalTime.now().toString());
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
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

class FibonacciThread extends Thread {
    public void run() {
        System.out.printf("[%s] Fibonacci thread starts (%s)\n", getName(), java.time.LocalTime.now().toString());

        long a1 = 1, a2 = 1;
        for (int i = 1; i <= 50; i++) {
            System.out.printf("[%s] the %d of Fibonacci: %d (%s)\n", getName(), i, a1, java.time.LocalTime.now().toString());

            long next = a1 + a2;
            a1 = a2;
            a2 = next;
            delay();
        }
        System.out.printf("[%s] Fibonacci thread ends (%s)\n", getName(), java.time.LocalTime.now().toString());
    }

    private void delay() {
        try {
            Thread.sleep((long) (Math.random() * 400 + 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FactorialThread extends Thread {
    public void run() {
        System.out.printf("[%s] Factorial thread starts (%s)\n", getName(), java.time.LocalTime.now().toString());

        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= 50; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            System.out.printf("[%s] the %d of Factorial: %d (%s)\n", getName(), i, factorial, java.time.LocalTime.now().toString());

            delay();
        }
        System.out.printf("[%s] Factorial thread ends (%s)\n", getName(), java.time.LocalTime.now().toString());
    }

    private void delay() {
        try {
            Thread.sleep((long) (Math.random() * 400 + 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MainA {
    public static void main(String[] args) {
        Thread primeThread = new PrimeThread();
        Thread fibonacciThread = new FibonacciThread();
        Thread factorialThread = new FactorialThread();

        primeThread.start();
        fibonacciThread.start();
        factorialThread.start();
    }
}
