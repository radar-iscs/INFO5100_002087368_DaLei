import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> cart = new HashMap<>();
        String input;

        while (true) {
            System.out.println("What kind of fruits do you want to buy?");
            System.out.print("Please enter Apple / Banana / Cherry, or 'check': ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("check")) {
                break;
            }

            try {
                Fruit fruit = FruitFactory.createFruit(input);

                System.out.print("How many pounds of " + fruit.getType() + " do you want to buy: ");
                int weight = Integer.parseInt(scanner.nextLine());

                cart.put(fruit.getType(), cart.getOrDefault(fruit.getType(), 0.0) + fruit.getPrice() * weight);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double sum = 0;
        System.out.println("\nYour have bought:");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            String fruitType = entry.getKey();
            Double price = entry.getValue();
            sum += price;
            System.out.printf("$%.2f of %s\n", price, fruitType);
        }

        System.out.printf("You should pay $%.2f\n", sum);
        scanner.close();
    }
}