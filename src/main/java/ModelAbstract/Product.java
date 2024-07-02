package ModelAbstract;

public abstract class Product {
    private static int idCounter = 101;
    int id;
    String productName;
    double price;
    int quantity;

    public Product (String productName, double price, int quantity) {
        setId();
        setProductName(productName);
        this.price = price;
        setQuantity(quantity);
    }

    // Helper methods.
    private void setId() {
        this.id = idCounter++;
    }


    // Getters and Setters.
    public int getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.productName = productName;
    }
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }
    public void setQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.quantity = amount;
    }

    // Abstract methods.
    public abstract String examine();
    public abstract String use();
}
