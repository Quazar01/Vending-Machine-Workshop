package ModelInterface;

import java.util.UUID;

public class ProteinBar implements Product{
    private int id;
    private String productName;
    private double price;
    private int amount;

    private String flavor;
    private String barCode;

    // Constructors
    public ProteinBar(int id, String productName, int amount, double price, String flavor) {
        setId(id);
        setProductName(productName);
        setPrice(price);
        setBarCode();
        setQuantity(amount);
        setFlavor(flavor);
    }

    public ProteinBar(String productName, int amount, double price) {
        setProductName(productName);
        setPrice(price);
        setBarCode();
        setQuantity(amount);
        this.flavor = "Chocolate";
    }

    // Helper Methods.
    private void setId(int id){
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be negative.");
        }
        this.id = id;
    }
    private void setBarCode() {
        this.barCode = UUID.randomUUID().toString().substring(0, 12);
    }

    // Getters and Setters.
    public String getFlavor() {
        return flavor;
    }
    public String getBarCode() {
        return barCode;
    }

    public void setFlavor(String flavor) {
        if (flavor == null || flavor.isEmpty()) {
            throw new IllegalArgumentException("Flavor cannot be empty.");
        }
        this.flavor = flavor;
    }

    @Override
    public String examine() {
        return "High quality protein bar with " + flavor + " flavor." +
                "\nYou want to buy all of them?! Well only have " + amount + " of it" +
                "\nPrice:  " + getPrice() + " SEK. " +
                "Pssst, you can use it as a snack or after workout.";
    }

    @Override
    public String use() {
        return "Here it comes the " + getProductName() + " protein bar. ";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.productName = productName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    @Override
    public int getQuantity() {
        return amount;
    }

    @Override
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        if (quantity > 100) {
            throw new IllegalArgumentException("Vending machine cannot hold more than 100 items of protein bars.");
        }
        this.amount = quantity;
    }
}
