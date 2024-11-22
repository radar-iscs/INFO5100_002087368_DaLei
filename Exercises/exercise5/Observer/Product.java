import java.util.ArrayList;

public class Product {
    private int price;
    private ArrayList<Customer> observers = new ArrayList<Customer>();

    public Product(int price) {
        this.price = price;
    }

    public void addObserver(Customer observer) {
        observers.add(observer);
    }

    public void updatePrice(int newPrice) {
        if (price != newPrice) {
            notifyAllObservers(price);
            price = newPrice;
        }
    }

    public void notifyAllObservers(int originalPrice) {
        for (Customer observer : observers) {
            observer.notifyUpdate(originalPrice, price);
        }
    }
}