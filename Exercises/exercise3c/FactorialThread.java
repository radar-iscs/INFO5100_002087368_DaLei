import java.math.BigInteger;

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
