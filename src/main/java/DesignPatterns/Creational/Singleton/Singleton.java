// Singleton Logger class
package DesignPatterns.Creational.Singleton;
class Logger {
    // Step 1: Create a private static volatile instance of the Logger
    private static volatile Logger instance;

    // Step 2: Make the constructor private to prevent instantiation
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Step 3: Provide a public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {  // First check (no locking)
            synchronized (Logger.class) {  // Locking for thread safety
                if (instance == null) {  // Second check with locking
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Example method to log messages
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

// Example Application class using the Singleton Logger
public class Singleton {
    public static void main(String[] args) {
        // Fetching the Singleton instance of Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("Starting the application...");

        // Fetching the Singleton instance of Logger again
        Logger logger2 = Logger.getInstance();
        logger2.log("Continuing the application...");

        // Checking if logger1 and logger2 refer to the same instance
        if (logger1 == logger2) {
            System.out.println("Logger is a singleton - both references are the same instance.");
        } else {
            System.out.println("Logger is NOT a singleton.");
        }
    }
}
