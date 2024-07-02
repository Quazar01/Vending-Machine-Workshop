package ModelInterface;

public class Nuts implements Product{
    private int id;
    private String productName;
    private double price;
    private int quantity;
    private int volumeInGrams;

    // Constructors
    public Nuts(int id, String productName, int quantity, double price, int volumeInGrams) {
        setId(id);
        setProductName(productName);
        setPrice(price);
        setQuantity(quantity);
        setVolumeInGrams(volumeInGrams);
    }

    // In case the volume is not specified, we assume it is 75 grams.
    public Nuts(int id, String productName, int quantity, double price) {
        setId(id);
        setProductName(productName);
        setPrice(price);
        setQuantity(quantity);
        this.volumeInGrams = 75;
    }

    // Helper Methods.
    private void setId(int id){
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be negative.");
        }
        this.id = id;
    }
    private void setVolumeInGrams(int volumeInGrams) {
        if (volumeInGrams < 0) {
            throw new IllegalArgumentException("Volume cannot be negative.");
        }
        this.volumeInGrams = volumeInGrams;
    }


    @Override
    public String examine() {
        return "Nuts are a great source of protein and healthy fats. " +
                "\nYou want to buy all of them?! Well only have " + getQuantity() + " of it" +
                "\nPrice:  " + getPrice() + " SEK.";
    }

    @Override
    public String use() {
        return "Here it comes the " + getProductName() + " nuts. ";
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
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }
}
