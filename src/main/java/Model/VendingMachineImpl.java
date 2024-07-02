package Model;

public class VendingMachineImpl implements VendingMachine{
    private Product[] products;
    private int depositPool;

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
        throw new IllegalArgumentException("Invalid amount.");
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                if (product.getAmount() == 0) {
                    throw new IllegalArgumentException("Product is out of stock.");
                }
                if (product.getPrice() <= depositPool) {
                    depositPool -= (int) product.getPrice();
                    product.amount -= 1;
                    return product;
                } else {
                    throw new IllegalArgumentException("Insufficient funds.");
                }
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        int change = (int) depositPool;
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
        throw new IllegalArgumentException("Product not found.");
    }

    @Override
    public String[] getProducts() {
        String[] productNames = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            int prodId = products[i].getId();
            String prodName = products[i].getProductName();
            productNames[i] = prodId + " " + prodName + "    " + products[i].getAmount();
        }
        return productNames;
    }
}
