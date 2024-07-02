package Model;

import java.util.UUID;

public class ProtienBar extends Product{
    private String flavor;
    private String barCode;

    // Constructors
    public ProtienBar(String productName, int amount, double price, String flavor) {
        super(productName, price, amount);
        setBarCode();
        setAmount(amount);
        setFlavor(flavor);
    }

    public ProtienBar(String productName, int amount, double price) {
        super(productName, price, amount);
        setBarCode();
        setAmount(amount);
        this.flavor = "Chocolate";
    }


    // Helper Methods.
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
    String examine() {
        return "High quality protein bar with " + flavor + " flavor." +
                "\nYou want to buy all of them?! Well only have " + amount + " of it" +
                "\nPrice:  " + getPrice() + " SEK. " +
                "Pssst, you can use it as a snack or after workout.";
    }

    @Override
    String use() {

        return "Here it comes the " + getProductName() + " protein bar. ";
    }
}
