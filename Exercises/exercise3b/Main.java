import java.io.*;

abstract class Shape implements Serializable {
    private static final long serialVersionUID = 1234L;

    abstract String getType();

    abstract String getColor();
    abstract void setColor(String color);

    abstract double calculateArea();
    abstract double calculatePerimeter();

    void printDescription() {
        System.out.println("Derived from Shape.");
    }
}

class Triangle extends Shape {
    private static final long serialVersionUID = 1234L;
    private String color;

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public String getType() {
        return "triangle";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    void printDescription() {
        System.out.println("Override from " + getType());
    }
}

class Circle extends Shape {
    private static final long serialVersionUID = 1234L;

    private String color;

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getType() {
        return "circle";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private static final long serialVersionUID = 1234L;

    private String color;

    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public String getType() {
        return "rectangle";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double calculateArea() {
        return width * length;
    }

    public double calculatePerimeter() {
        return (width + length) * 2;
    }

    @Override
    void printDescription() {
        System.out.println("Override from " + getType());
    }
}

class Square extends Rectangle {
    private static final long serialVersionUID = 1234L;

    public Square(double side) {
        super(side, side);
    }

    @Override
    public String getType() {
        return "square";
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Shape triangle = new Triangle(3, 3, 3);
            Shape rectangle = new Rectangle(2, 4);
            Shape square = new Square(3);
            Shape circle = new Circle(2);

            Shape[] shapes = {triangle, rectangle, square, circle};

            // Serialize
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("shapes.ser"))) {
                outputStream.writeObject(shapes);
            }

            // Deserialize
            Shape[] deserializedShapes;
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("shapes.ser"))) {
                deserializedShapes = (Shape[]) inputStream.readObject();
            }

            System.out.println("Deserialized:");
            for (Shape shape : deserializedShapes) {
                System.out.printf("%s's perimeter: %.5f, area: %.5f\n", shape.getType(), shape.calculatePerimeter(), shape.calculateArea());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
