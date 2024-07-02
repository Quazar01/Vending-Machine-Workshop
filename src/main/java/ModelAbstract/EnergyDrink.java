package ModelAbstract;

import java.util.UUID;

public class EnergyDrink extends Product {
    private String barCode;
    private int sizeInML;

    // Constructors
    public EnergyDrink(String productName, int quantity, double price, int sizeInML) {
        super(productName, price, quantity);
        setBarCode();
        setSizeInML(sizeInML);
    }

    public EnergyDrink(String productName, double price, int amount) {
        super(productName, price, amount);
        setBarCode();
        setQuantity(amount);
        this.sizeInML = 330;
    }

    // Helper Methods.
    private void setBarCode() {
        this.barCode = UUID.randomUUID().toString().substring(0, 12);
    }

    // Getters and Setters.
    public int getSizeInML() {
        return sizeInML;
    }
    public String getBarCode() {
        return barCode;
    }

    public void setSizeInML(int sizeInML) {
        if (sizeInML < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        this.sizeInML = sizeInML;
    }


    @Override
    public String examine() {
        return "Energize yourself with " + getProductName() + " with " + sizeInML + " ml." +
                "\nYou want to buy all of them?! Well only have " + getQuantity() + " of it" +
                "\nPrice:  " + getPrice() + " SEK.";
    }

    @Override
    public String use() {
        return "Here it comes the " + getProductName() + " energy drink. ";
    }
}
