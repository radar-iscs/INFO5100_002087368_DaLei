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
