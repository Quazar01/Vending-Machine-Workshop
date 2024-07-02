package se.lexicon;
import ModelInterface.*;

/**
 *  Vending Machine Workshop.
 *  The main class of the application.
 */
public class App 
{
    private static int id = 100;
    public static void main( String[] args )
    {
        // Create products.
        Product[] products = new Product[3];
        products[0] = new ProteinBar(generateId(), "Quest", 10, 25.5, "Chocolate");
        products[1] = new EnergyDrink(generateId(), "NOCCO", 20, 20.5, 500);
        products[2] = new Nuts(generateId(), "Cashew", 15, 30.5, 150);

        // Create vending machine.
        VendingMachineImpl vendingMachine = new VendingMachineImpl(products);
        System.out.println("Products in vending machine:");
        System.out.println(" id Name  quantity  Price" );
        String[] productsDetails = vendingMachine.getProducts();
        for (String productDetails : productsDetails) {
            System.out.println(productDetails);
        }
        vendingMachine.addCurrency(500);
        int balance = vendingMachine.getBalance();
        System.out.println("\nInserting balance: " + balance);

        // Buy a product.
        System.out.println("\nBuying a product.");
        Product product = vendingMachine.request(102);
        System.out.println(product.use());
        System.out.println("Product bought: " + product.getProductName() + " for " + product.getPrice() + " SEK.\n");


        System.out.println(" id Name  quantity  Price" );
        // Update product list.
        productsDetails = vendingMachine.getProducts();
        for (String productDetails : productsDetails) {
            System.out.println(productDetails);
        }
        // Update the balance.
        balance = vendingMachine.getBalance();
        System.out.println("Balance after buying the product: " + balance);

        // Get the description of a product.
        System.out.println("\nGetting the description of a product.");
        String description = vendingMachine.getDescription(102);
        System.out.println();
        System.out.println(description);

        // End the session.
        System.out.println("\nEnding the session.");
        int change = vendingMachine.endSession();
        int dpo = vendingMachine.getBalance();
        System.out.println("\nSession ended.");
        System.out.println("Change: " + change + "\nDeposit Pool: " + dpo);

    }

    private static int generateId() {
        id = id + 1;
        return id;
    }
}
