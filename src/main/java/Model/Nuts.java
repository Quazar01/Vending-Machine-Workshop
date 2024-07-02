package Model;

import java.util.UUID;

public class Nuts extends Product{
    private String barCode;
    private int sizeInGrams;

    public Nuts(String productName, double price, int amount, int sizeInGrams) {
        super(productName, price, amount);
        setSizeInGrams(sizeInGrams);
    }

    public Nuts(String productName, double price, int amount) {
        super(productName, price, amount);
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

    public void setSizeInGrams(int sizeInGrams) {
        if (sizeInGrams < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        this.sizeInGrams = sizeInGrams;
    }


    @Override
    String examine() {
        return "Nuts are a great source of protein and healthy fats. " +
                "\nYou want to buy all of them?! Well only have " + getAmount() + "of it" +
                "\nPrice:  " + getPrice() + " SEK.";
    }

    @Override
    String use() {
        if (getAmount() > 0) {
            setAmount(getAmount() - 1);
            return "Here it comes the " + getProductName() + " nuts. ";
        }
        else {
            return "Sorry, we are out of " + getProductName() + " nuts.";
        }
    }
}
