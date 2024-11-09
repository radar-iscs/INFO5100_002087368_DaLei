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
