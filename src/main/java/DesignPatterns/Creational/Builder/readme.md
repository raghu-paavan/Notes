The **Builder** design pattern is useful when creating complex objects that require multiple steps or configurations. This pattern provides a flexible solution for creating complex objects by separating construction from representation.

### Example Scenario

Let's create a `House` class where different features can be customized, like the number of bedrooms, bathrooms, and other options. The `HouseBuilder` class will be used to construct `House` objects, providing flexibility in setting optional parameters.

### Example Code

```java
// House class with multiple optional parameters
public class House {
    // Required parameters
    private final int bedrooms;
    private final int bathrooms;

    // Optional parameters
    private final boolean hasGarage;
    private final boolean hasSwimmingPool;
    private final boolean hasGarden;

    // Private constructor, accessible only through the Builder
    private House(HouseBuilder builder) {
        this.bedrooms = builder.bedrooms;
        this.bathrooms = builder.bathrooms;
        this.hasGarage = builder.hasGarage;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasGarden = builder.hasGarden;
    }

    @Override
    public String toString() {
        return "House [bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + 
               ", hasGarage=" + hasGarage + ", hasSwimmingPool=" + hasSwimmingPool + 
               ", hasGarden=" + hasGarden + "]";
    }

    // Static nested Builder class
    public static class HouseBuilder {
        // Required parameters
        private final int bedrooms;
        private final int bathrooms;

        // Optional parameters - initialized to default values
        private boolean hasGarage = false;
        private boolean hasSwimmingPool = false;
        private boolean hasGarden = false;

        // Constructor with required parameters
        public HouseBuilder(int bedrooms, int bathrooms) {
            this.bedrooms = bedrooms;
            this.bathrooms = bathrooms;
        }

        // Setter for optional feature hasGarage
        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        // Setter for optional feature hasSwimmingPool
        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        // Setter for optional feature hasGarden
        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        // Build method to create a House object
        public House build() {
            return new House(this);
        }
    }
}

// Client code demonstrating the Builder pattern
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Creating a House with only required parameters
        House simpleHouse = new House.HouseBuilder(3, 2).build();
        System.out.println(simpleHouse);

        // Creating a House with optional features
        House luxuryHouse = new House.HouseBuilder(5, 4)
                                        .setGarage(true)
                                        .setSwimmingPool(true)
                                        .setGarden(true)
                                        .build();
        System.out.println(luxuryHouse);
    }
}
```

### Explanation of the Code

1. **`House` Class**:
    - The `House` class has both required (`bedrooms`, `bathrooms`) and optional parameters (`hasGarage`, `hasSwimmingPool`, `hasGarden`).
    - The constructor is private, meaning `House` objects can only be created through the `HouseBuilder`.
2. **`HouseBuilder` Static Nested Class**:
    - Contains both required parameters (`bedrooms` and `bathrooms`) and optional parameters with default values.
    - Provides **setter methods** (e.g., `setGarage()`, `setSwimmingPool()`, `setGarden()`) that return the `HouseBuilder` instance, enabling method chaining.
    - The `build()` method creates a `House` instance with the configurations set in the builder.
3. **Client Code**:
    - Demonstrates two ways to create a `House`:
        - **Simple House**: Only with required parameters.
        - **Luxury House**: Using required and optional parameters to create a custom configuration.

### Output

```plaintext
House [bedrooms=3, bathrooms=2, hasGarage=false, hasSwimmingPool=false, hasGarden=false]
House [bedrooms=5, bathrooms=4, hasGarage=true, hasSwimmingPool=true, hasGarden=true]
```

### Benefits of the Builder Pattern

- **Flexibility**: The builder pattern allows setting only the parameters needed.
- **Readability**: By chaining methods, the code reads naturally, and it’s easy to see which features have been customized.
- **Immutability**: The final `House` object can be made immutable since all parameters are set before the object is created.

This pattern is commonly used for objects that need various optional configurations, like database connections, HTTP clients, and, as shown here, custom objects like `House`.
