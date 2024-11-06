The **Proxy** design pattern provides a surrogate or placeholder for another object to control access to it. The proxy object has the same interface as the target object and controls access to it, often for purposes like **lazy initialization**, **access control**, **logging**, or **caching**.

### Example Scenario

Consider a **Document Viewer** system where loading a high-resolution document (e.g., PDF or image) is a heavy operation. A **Proxy** class can be used to delay the loading until it’s needed (lazy loading). The client interacts with the proxy, which only loads the actual document data when requested.

### Example Code

```java
// Step 1: Define the Document interface
interface Document {
    void display();
}

// Step 2: Create the RealDocument class representing the actual resource-intensive document
class RealDocument implements Document {
    private String filename;

    public RealDocument(String filename) {
        this.filename = filename;
        loadFromDisk(); // Expensive operation done once at instantiation
    }

    // Simulates loading the document from disk (heavy operation)
    private void loadFromDisk() {
        System.out.println("Loading document from disk: " + filename);
    }

    // Displaying the document
    @Override
    public void display() {
        System.out.println("Displaying document: " + filename);
    }
}

// Step 3: Create the DocumentProxy class, controlling access to RealDocument
class DocumentProxy implements Document {
    private String filename;
    private RealDocument realDocument; // Lazily loaded RealDocument instance

    public DocumentProxy(String filename) {
        this.filename = filename;
    }

    // Lazy initialization of the RealDocument
    @Override
    public void display() {
        if (realDocument == null) {
            realDocument = new RealDocument(filename); // Load only on first access
        }
        realDocument.display();
    }
}

// Step 4: Client code using the proxy
public class ProxyPatternExample {
    public static void main(String[] args) {
        // The proxy handles access to the RealDocument
        Document doc = new DocumentProxy("my_document.pdf");

        // First access, document is loaded from disk
        doc.display();

        System.out.println();

        // Second access, document is already loaded and reused
        doc.display();
    }
}
```

### Explanation of the Code

1. **Document Interface** (`Document`):
    - Defines the common interface for both `RealDocument` and `DocumentProxy`, allowing them to be used interchangeably by the client.

2. **RealDocument Class** (`RealDocument`):
    - This is the actual class performing a heavy operation (e.g., `loadFromDisk()`).
    - `display()` shows the document, simulating some operations after loading.

3. **Proxy Class** (`DocumentProxy`):
    - Holds a reference to `RealDocument`, and it loads this object only on the first `display()` call (lazy loading).
    - Controls access to `RealDocument`, making it efficient by loading the document only once and reusing it in subsequent calls.

4. **Client Code** (`ProxyPatternExample` Class):
    - Uses the `Document` interface, but through the `DocumentProxy` object.
    - The first `display()` call loads the document, and further calls reuse the already-loaded document.

### Output

```plaintext
Loading document from disk: my_document.pdf
Displaying document: my_document.pdf

Displaying document: my_document.pdf
```

### Advantages of the Proxy Pattern

1. **Lazy Initialization**:
    - Delays object loading until needed, improving efficiency, especially for heavy or memory-intensive objects.

2. **Access Control**:
    - Can control access by adding authorization layers before accessing the real object.

3. **Logging or Monitoring**:
    - Useful for logging operations or tracking access to an object without modifying the actual class.

4. **Cost Reduction**:
    - Helps reduce the cost by sharing resources, such as by controlling access to a limited pool of resources.

The Proxy pattern is ideal for scenarios requiring controlled access, resource management, or extra security, allowing you to add these features without changing the core logic of the actual class.