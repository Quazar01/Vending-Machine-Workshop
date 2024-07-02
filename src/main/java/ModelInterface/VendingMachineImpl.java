package ModelInterface;

public class VendingMachineImpl implements VendingMachine{
    private Product[] products;
    private int depositPool;

    // Constructor
    public VendingMachineImpl(Product[] products) {
        this.products = products;
        this.depositPool = 0;
    }
    @Override
    public void addCurrency(int amount) {
        int[] validAmounts = new int[] {1, 5, 10, 20, 50, 100, 200, 500, 1000};
        for (int validAmount : validAmounts) {
            if (amount == validAmount) {
                depositPool += amount;
                return;
            }
        }
        System.out.println("Invalid currency. Please use valid currency.");
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                if (product.getQuantity() == 0) {
                    System.out.printf("Product %s is out of stock.\n", product.getProductName());
                    return null;
                }
                if (product.getPrice() <= depositPool) {
                    depositPool -= (int) product.getPrice();
                    product.setQuantity(product.getQuantity() - 1);
                    return product;
                } else {
                    System.out.println("Insufficient funds.");
                    return null;
                }
            }
        }
        System.out.println("Product not found.");
        return null;
    }

    @Override
    public int endSession() {
        int change = depositPool;
        depositPool = 0;
        return change;
    }

    @Override
    public String getDescription(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product.examine();
            }
        }
        return "Product not found.";
    }

    @Override
    public String[] getProducts() {
        String[] productNames = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            productNames[i] = products[i].getId() + " " + products[i].getProductName() + "   "
                    + products[i].getQuantity() + "       " + products[i].getPrice();
        }
        return productNames;
    }
}
