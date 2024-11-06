package DesignPatterns.Structural.Facade;
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

