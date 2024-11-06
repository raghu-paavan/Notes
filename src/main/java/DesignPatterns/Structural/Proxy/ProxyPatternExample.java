package DesignPatterns.Structural.Proxy;

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
