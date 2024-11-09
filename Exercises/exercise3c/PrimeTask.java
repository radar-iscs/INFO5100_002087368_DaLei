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
