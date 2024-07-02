package Model;

public abstract class Product {

    int id;
    String productName;
    double price;
    int amount;

    public Product (String productName, double price, int amount) {
        setId();
        setProductName(productName);
        this.price = price;
        setAmount(amount);
    }

    // Helper methods.
    private void setId() {
        this.id = (int) (Math.random() * (1000 - 100 + 1) + 100);
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
    public int getAmount() {
        return amount;
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
    public void setAmount (int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.amount = amount;
    }

    // Abstract methods.

    abstract String examine();
    abstract String use();
}
