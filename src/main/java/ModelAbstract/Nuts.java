package ModelAbstract;

import java.util.UUID;

public class Nuts extends Product{
    private String barCode;
    private int sizeInGrams;

    public Nuts(String productName, double price, int quantity, int sizeInGrams) {
        super(productName, price, quantity);
        setSizeInGrams(sizeInGrams);
    }

    public Nuts(String productName, double price, int quantity) {
        super(productName, price, quantity);
        this.sizeInGrams = 150;
    }

    // Helper Methods.
    private void setBarCode() {
        this.barCode = UUID.randomUUID().toString().substring(0, 12);
    }

    // Getters and Setters.
    public int getSizeInGrams() {
        return sizeInGrams;
    }
    public String getBarCode() {
        return barCode;
    }

    public void setSizeInGrams(int sizeInGrams) {
        if (sizeInGrams < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        this.sizeInGrams = sizeInGrams;
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
}
