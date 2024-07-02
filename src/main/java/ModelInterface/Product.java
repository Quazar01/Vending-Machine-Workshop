package ModelInterface;

public interface Product {
    String examine();
    String use();
    int getId();
    String getProductName();
    void setProductName(String productName);
    double getPrice();
    void setPrice(double price);
    int getQuantity();
    void setQuantity(int quantity);
}
