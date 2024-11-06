package DesignPatterns.Structural.Decorator;
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
