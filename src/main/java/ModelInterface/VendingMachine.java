package ModelInterface;

public interface VendingMachine {

    void addCurrency(int amount);
    int getBalance();
    Product request(int productId);
    int endSession();
    String getDescription(int productId);
    String[] getProducts();
}
