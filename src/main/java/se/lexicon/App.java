package se.lexicon;
import Model.*;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Create products.
        Product[] products = new Product[3];
        products[0] = new ProtienBar("Quest", 10, 17.99, "Coconuts");
        products[1] = new EnergyDrink("NOCCO", 20, 21.5, 330);
        products[2] = new Nuts("Cashew", 25.99, 10, 125);

        // Create vending machine.
        VendingMachine vendingMachine = new VendingMachineImpl(products);
        System.out.println("Products in vending machine:");
        System.out.println(" id Name  Amount" );
        String[] productNames = vendingMachine.getProducts();
        for (String productName : productNames) {
            System.out.println(productName);
        }
        vendingMachine.addCurrency(500);
        int balance = vendingMachine.getBalance();
        System.out.println("Balance: " + balance);

        // Buy a product.
        Product product = vendingMachine.request(101);
        System.out.println("Product bought: " + product.getProductName());

        System.out.println(" id Name  Amount" );
        // Update product list.
        productNames = vendingMachine.getProducts();
        for (String productName : productNames) {
            System.out.println(productName);
        }
        // Update the balance.
        balance = vendingMachine.getBalance();
        System.out.println("Balance: " + balance);

        // Get the description of a product.
        String description = vendingMachine.getDescription(102);
        System.out.println();
        System.out.println(description);

        // End the session.
        int change = vendingMachine.endSession();
        int dpo = vendingMachine.getBalance();
        System.out.println("Session ended.");
        System.out.println("Change: " + change + "\nDeposit Pool: " + dpo);


    }
}
