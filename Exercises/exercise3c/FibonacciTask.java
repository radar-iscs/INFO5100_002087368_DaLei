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
