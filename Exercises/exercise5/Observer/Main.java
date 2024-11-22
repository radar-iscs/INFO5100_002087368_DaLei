public class Main {
    public static void main(String[] args) {
        Product product = new Product(5);
        Customer a = new Customer("Jack", product);
        Customer b = new Customer("Lily", product);
        System.out.println("Price updated:");
        product.updatePrice(15);

        Customer c = new Customer("Tom", product);
        System.out.println("\nPrice updated:");
        product.updatePrice(10);
    }
}
