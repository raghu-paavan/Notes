The **Facade** design pattern provides a simplified interface to a complex subsystem, making it easier for clients to interact with it. This pattern is helpful when a system has multiple interdependent classes or methods, and you want to hide this complexity from the user.

### Example Scenario

Consider a **Home Theater** system that consists of various components like `Projector`, `SoundSystem`, `Lights`, and `DVDPlayer`. Each component has its own setup, start, and stop methods, but for the user, we only want to expose a simple `watchMovie()` and `endMovie()` interface, abstracting the complex setup and shutdown process.

### Example Code

```java
// Step 1: Define subsystem classes with their specific functionality
class Projector {
    public void on() {
        System.out.println("Projector is now ON.");
    }

    public void off() {
        System.out.println("Projector is now OFF.");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to " + input);
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound system is now ON.");
    }

    public void off() {
        System.out.println("Sound system is now OFF.");
    }

    public void setVolume(int level) {
        System.out.println("Sound volume set to " + level);
    }
}

class Lights {
    public void dim(int level) {
        System.out.println("Lights are dimmed to " + level + "%.");
    }

    public void on() {
        System.out.println("Lights are now ON.");
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD player is now ON.");
    }

    public void off() {
        System.out.println("DVD player is now OFF.");
    }

    public void play(String movie) {
        System.out.println("Playing \"" + movie + "\".");
    }
}

// Step 2: Create the Facade class to simplify the interface for the client
class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;
    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade(Projector projector, SoundSystem soundSystem, Lights lights, DVDPlayer dvdPlayer) {
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
        this.dvdPlayer = dvdPlayer;
    }

    // Simplified method to start the movie
    public void watchMovie(String movie) {
        System.out.println("Getting ready to watch a movie...");
        lights.dim(10);
        projector.on();
        projector.setInput("DVD Player");
        soundSystem.on();
        soundSystem.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
        System.out.println("Enjoy the movie!");
    }

    // Simplified method to end the movie
    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        lights.on();
        projector.off();
        soundSystem.off();
        dvdPlayer.off();
        System.out.println("Goodbye!");
    }
}

// Step 3: Client code to use the simplified interface of HomeTheaterFacade
public class FacadePatternExample {
    public static void main(String[] args) {
        // Initialize all the components
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();
        DVDPlayer dvdPlayer = new DVDPlayer();

        // Create the facade for the home theater
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, soundSystem, lights, dvdPlayer);

        // Start the movie using a single call
        homeTheater.watchMovie("Inception");

        System.out.println("\n--- Movie ended ---\n");

        // End the movie using a single call
        homeTheater.endMovie();
    }
}
```

### Explanation of the Code

1. **Subsystem Classes (`Projector`, `SoundSystem`, `Lights`, and `DVDPlayer`)**:
    - Each subsystem class has its own specific methods (like `on`, `off`, `setVolume`, `dim`, etc.) that would typically need to be controlled individually.

2. **Facade Class (`HomeTheaterFacade`)**:
    - This class provides a simple interface (`watchMovie()` and `endMovie()`) for clients to interact with the subsystem.
    - In `watchMovie()`, it sequences multiple operations across subsystems to set up the home theater.
    - In `endMovie()`, it sequences operations to shut down the home theater.

3. **Client Code (`FacadePatternExample` Class)**:
    - The client interacts only with `HomeTheaterFacade` instead of managing individual subsystems.
    - The client calls `watchMovie()` to start and `endMovie()` to stop the movie experience, simplifying the process.

### Output

```plaintext
Getting ready to watch a movie...
Lights are dimmed to 10%.
Projector is now ON.
Projector input set to DVD Player
Sound system is now ON.
Sound volume set to 5
DVD player is now ON.
Playing "Inception".
Enjoy the movie!

--- Movie ended ---

Shutting down the home theater...
Lights are now ON.
Projector is now OFF.
Sound system is now OFF.
DVD player is now OFF.
Goodbye!
```

### Advantages of the Facade Pattern

1. **Simplifies Client Usage**:
    - Provides an easy-to-use, high-level interface, reducing the client’s dependency on complex subsystems.

2. **Reduces Code Duplication**:
    - Centralizes and encapsulates complex interactions, which can be reused by multiple clients.

3. **Improves Maintenance and Scalability**:
    - Modifying subsystem logic only affects the Facade, not the client code.

4. **Enhances Loose Coupling**:
    - Clients are decoupled from subsystem components, improving code flexibility.

The Facade pattern is common when you need to streamline access to complex systems, such as libraries, APIs, or services. This way, the facade handles intricate details, letting clients focus on high-level tasks.