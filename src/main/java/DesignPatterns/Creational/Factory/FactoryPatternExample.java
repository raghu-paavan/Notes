package DesignPatterns.Creational.Factory;

// Step 1: Define the Shape interface
interface Shape {
    void draw();
}

// Step 2: Implement concrete classes for different shapes
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Step 3: Create a Factory class to generate objects of different shapes based on input
class ShapeFactory {
    // Use getShape method to get an object of a specified shape type
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            case "rectangle":
                return new Rectangle();
            default:
                System.out.println("Unknown shape type.");
                return null;
        }
    }
}

// Client code to use the Factory
public class FactoryPatternExample {
    public static void main(String[] args) {
        // Create an instance of the ShapeFactory
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get a Circle object and call its draw method
        Shape shape1 = shapeFactory.getShape("circle");
        if (shape1 != null) shape1.draw();

        // Get a Square object and call its draw method
        Shape shape2 = shapeFactory.getShape("square");
        if (shape2 != null) shape2.draw();

        // Get a Rectangle object and call its draw method
        Shape shape3 = shapeFactory.getShape("rectangle");
        if (shape3 != null) shape3.draw();

        // Try an unknown shape type
        Shape shape4 = shapeFactory.getShape("triangle");
        if (shape4 != null) shape4.draw();
    }
}
