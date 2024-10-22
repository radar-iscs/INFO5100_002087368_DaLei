abstract class Shape {
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
    static String color;

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
        Triangle.color = color;
    }

    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return (double)Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
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
    static String color;

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
        Circle.color = color;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    static String color;

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
        Rectangle.color = color;
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
        Shape triangle = new Triangle(3, 3, 3);
        Shape rectangle = new Rectangle(2, 4);
        Shape square = new Square(3);
        Shape circle = new Circle(2);
        Shape[] shapes = {triangle, rectangle, square, circle};

        System.out.println("Override:");
        for (Shape shape : shapes) {
            shape.printDescription();
        }

        System.out.println("\nPolymorphism:");
        for (Shape shape : shapes) {
            System.out.printf("%s's perimeter: %.5f, area: %.5f\n", shape.getType(), shape.calculatePerimeter(), shape.calculateArea());
        }

        System.out.println("\nStatic Field:");
        Shape triangle1 = new Triangle(3, 3, 3);
        Shape triangle2 = new Triangle(3, 4, 5);
        System.out.printf("Color of triangles after initiating\ntriangle1: %s, triangle2: %s\n", triangle1.getColor(), triangle2.getColor());
        triangle1.setColor("red");
        System.out.printf("Color of triangles after setting triangle1\ntriangle1: %s, triangle2: %s\n", triangle1.getColor(), triangle2.getColor());
    }
}
