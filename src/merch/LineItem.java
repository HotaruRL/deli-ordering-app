package merch;

public interface LineItem {
    double getPrice();
    double getUnitPrice();
    int getQuantity();
    String getReceiptDetails();
}
