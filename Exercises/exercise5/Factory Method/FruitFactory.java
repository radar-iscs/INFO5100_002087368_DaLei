public class FruitFactory {
    public static Fruit createFruit(String type) {
        return switch (type.toLowerCase()) {
            case "apple" -> new Apple();
            case "banana" -> new Banana();
            case "cherry" -> new Cherry();
            default -> throw new IllegalArgumentException("Unknown fruit type: " + type);
        };
    }
}
