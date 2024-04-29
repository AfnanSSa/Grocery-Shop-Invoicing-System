package InvoiceSystem;

public interface InvoiceHandler {
    void createInvoice();
    void reportItemStatistics();
    void reportAllInvoices();
    void searchInvoices();
    Item findItemByID(Integer itemID);
    void displayAllItems();

}
