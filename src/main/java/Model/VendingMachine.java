package Model;

public interface VendingMachine {
    void addCurrency(int amount);
    int getBalance();
    Product request(int productId);
    int ednSession();
    String getDescription(int productId);
    String[] getProducts();
}
