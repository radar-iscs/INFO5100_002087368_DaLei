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
