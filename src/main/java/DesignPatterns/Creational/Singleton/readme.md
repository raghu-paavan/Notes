Here's a complete example in Java illustrating the Singleton design pattern. This example uses a **Logger** class, which is often implemented as a singleton so that all parts of an application can log messages to the same place.

### Explanation of the Singleton Pattern

1. **Single Instance**: We need only one instance of the `Logger` class across the entire application.
2. **Private Constructor**: To prevent direct instantiation from outside.
3. **Thread-Safe Lazy Initialization**: The instance is created only when needed and is thread-safe.

### Example Code

```java
// Singleton Logger class
public class Logger {
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
public class Application {
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
```

### Explanation of the Code

1. **Private Constructor**: `Logger()` is private, so no other class can instantiate `Logger` directly.
2. **Static Method `getInstance()`**: Ensures that only one instance of `Logger` is created, even in a multithreaded environment.
    - The **double-checked locking** pattern is used here to avoid the cost of synchronization after the singleton instance is initialized.
3. **Usage**:
    - We call `Logger.getInstance()` in `main()`, which ensures that the `Logger` instance is created only once. Subsequent calls to `getInstance()` return the same instance.
    - `log()` method is an example of the business logic you would typically add to a singleton class.

### Output

When you run the code, you’ll see:

```plaintext
Logger initialized.
[LOG] Starting the application...
[LOG] Continuing the application...
Logger is a singleton - both references are the same instance.
```

This output confirms that the `Logger` class is instantiated only once, and both `logger1` and `logger2` refer to the same object, verifying the Singleton pattern.