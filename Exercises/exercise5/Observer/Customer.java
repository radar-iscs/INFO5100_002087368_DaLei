public class Customer {
    private String name;
    private Product product;

    public Customer(String name, Product product) {
        this.name = name;
        this.product = product;
        this.product.addObserver(this);
    }

    public void notifyUpdate(int originalPrice, int newPrice) {
        System.out.printf("%s has received the information about price changing from %d to %d\n", name, originalPrice, newPrice);
    }
}
