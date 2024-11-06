package DesignPatterns.Creational.AbstractFactory;

// Step 1: Define abstract product interfaces
interface Chair {
    void sitOn();
}

interface Sofa {
    void layOn();
}

// Step 2: Implement concrete products for Modern style
class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair.");
    }
}

class ModernSofa implements Sofa {
    @Override
    public void layOn() {
        System.out.println("Laying on a modern sofa.");
    }
}

// Step 3: Implement concrete products for Victorian style
class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair.");
    }
}

class VictorianSofa implements Sofa {
    @Override
    public void layOn() {
        System.out.println("Laying on a Victorian sofa.");
    }
}

// Step 4: Define the abstract factory interface
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

// Step 5: Implement concrete factories for each furniture style
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

// Step 6: Client code that uses the abstract factory
public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        // Creating a Modern furniture factory
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Sofa modernSofa = modernFactory.createSofa();

        // Using the Modern furniture
        modernChair.sitOn();
        modernSofa.layOn();

        // Creating a Victorian furniture factory
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFactory.createChair();
        Sofa victorianSofa = victorianFactory.createSofa();

        // Using the Victorian furniture
        victorianChair.sitOn();
        victorianSofa.layOn();
    }
}
