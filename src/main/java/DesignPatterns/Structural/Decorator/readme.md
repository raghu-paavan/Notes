The **Decorator** design pattern allows behavior to be added to individual objects, dynamically and transparently, without affecting the behavior of other objects from the same class. The pattern is useful when you want to add responsibilities to objects at runtime without altering their class definitions.

### Example Scenario

Imagine a simple coffee shop where a `Coffee` can have optional add-ons like milk, sugar, or whipped cream. Each add-on has an extra cost. Using the Decorator pattern, we can add these extras to the coffee without changing the base `Coffee` class.

### Example Code

```java
// Step 1: Create a Component interface (Coffee)
interface Coffee {
    String getDescription();
    double getCost();
}

// Step 2: Implement a Concrete Component class (SimpleCoffee)
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// Step 3: Create the Decorator class implementing the Coffee interface
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

// Step 4: Implement Concrete Decorators for each add-on
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.5; // Extra cost for milk
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5; // Extra cost for sugar
    }
}

class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 2.0; // Extra cost for whipped cream
    }
}

// Step 5: Client code to demonstrate adding decorators dynamically
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " | Cost: $" + simpleCoffee.getCost());

        // Add milk
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription() + " | Cost: $" + milkCoffee.getCost());

        // Add sugar
        Coffee milkSugarCoffee = new SugarDecorator(milkCoffee);
        System.out.println(milkSugarCoffee.getDescription() + " | Cost: $" + milkSugarCoffee.getCost());

        // Add whipped cream
        Coffee deluxeCoffee = new WhippedCreamDecorator(milkSugarCoffee);
        System.out.println(deluxeCoffee.getDescription() + " | Cost: $" + deluxeCoffee.getCost());
    }
}
```

### Explanation of the Code

1. **Component Interface (`Coffee`)**:
    - Defines the basic structure with `getDescription()` and `getCost()` methods.

2. **Concrete Component (`SimpleCoffee`)**:
    - Provides the base implementation of `Coffee` (in this case, a simple coffee with no extras).

3. **Decorator Class (`CoffeeDecorator`)**:
    - Implements `Coffee` and holds a reference to a `Coffee` object. This base class forwards calls to the wrapped `Coffee` instance. Subclasses will override `getDescription()` and `getCost()` to add extra functionality.

4. **Concrete Decorators (`MilkDecorator`, `SugarDecorator`, `WhippedCreamDecorator`)**:
    - Each decorator adds its own behavior to the coffee (e.g., adding milk, sugar, or whipped cream). They modify `getDescription()` and `getCost()` to include the respective additions.

5. **Client Code**:
    - The client creates a `SimpleCoffee` object and then wraps it with decorators to add milk, sugar, and whipped cream dynamically.
    - The decorators allow us to build up the coffee's description and cost incrementally.

### Output

```plaintext
Simple Coffee | Cost: $5.0
Simple Coffee, Milk | Cost: $6.5
Simple Coffee, Milk, Sugar | Cost: $7.0
Simple Coffee, Milk, Sugar, Whipped Cream | Cost: $9.0
```

### Advantages of the Decorator Pattern

1. **Open for Extension, Closed for Modification**:
    - Allows adding new functionalities to objects without modifying existing code.

2. **Flexible Combinations**:
    - You can add any number and combination of decorators, allowing a variety of configurations at runtime.

3. **Enhances Single Responsibility**:
    - Each decorator class focuses on a single functionality, making it easier to maintain and modify individual behaviors.

The Decorator pattern is often used to implement flexible, reusable components with pluggable behaviors and is common in UI frameworks, stream I/O libraries, and where flexibility in functionality addition is needed.