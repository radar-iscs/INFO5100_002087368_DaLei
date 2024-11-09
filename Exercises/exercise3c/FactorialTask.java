import java.math.BigInteger;

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
