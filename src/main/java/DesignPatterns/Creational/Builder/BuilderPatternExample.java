package DesignPatterns.Creational.Builder;

// House class with multiple optional parameters
class House {
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
