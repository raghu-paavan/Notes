The **Factory** design pattern provides a way to create objects without exposing the creation logic to the client. Instead of calling a constructor directly, the client calls a factory method, which handles object creation based on provided parameters or conditions. This pattern is especially useful when the exact type of object to be created may vary depending on certain conditions.

### Example Scenario

Let’s consider a `Shape` interface with classes implementing different shapes (`Circle`, `Square`, and `Rectangle`). Instead of the client instantiating shapes directly, a `ShapeFactory` class will decide which type of `Shape` object to create based on input.

### Example Code

```java
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
```

### Explanation of the Code

1. **`Shape` Interface**:
    - The `Shape` interface has a single method `draw()`, which is implemented by each concrete shape class (`Circle`, `Square`, and `Rectangle`).

2. **Concrete Shape Classes**:
    - Each shape class (`Circle`, `Square`, and `Rectangle`) implements the `Shape` interface and defines its own `draw()` method.

3. **`ShapeFactory` Class**:
    - Contains the `getShape(String shapeType)` method, which takes in a `shapeType` and returns an object of the corresponding shape.
    - This factory method checks the input and returns an instance of the appropriate shape class. If an unrecognized shape type is provided, it returns `null`.

4. **Client Code**:
    - The client code (`FactoryPatternExample`) uses `ShapeFactory` to get instances of `Shape` objects based on the type.
    - The client doesn’t need to know the concrete classes (`Circle`, `Square`, `Rectangle`) directly, making the code more modular and maintainable.

### Output

```plaintext
Drawing a Circle
Drawing a Square
Drawing a Rectangle
Unknown shape type.
```

### Advantages of the Factory Pattern

1. **Encapsulation of Object Creation**: The client code is decoupled from the instantiation of objects.
2. **Simplified Client Code**: Clients can request objects without dealing with class constructors.
3. **Scalability**: New shapes can be added with minimal modification to the client code; only the factory class requires changes to support new shapes.

The Factory pattern is widely used in real-world applications where the type of object needed may change based on runtime conditions, and the creation logic needs to be isolated from the client.