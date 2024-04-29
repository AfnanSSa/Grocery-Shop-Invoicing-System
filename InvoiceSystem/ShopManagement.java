package InvoiceSystem;

import java.util.Scanner;

public interface ShopManagement {
    void loadData();
    void setShopName();
    void setInvoiceHeader();
    void addInvoice(Invoice invoice);
    Integer inputValidation(Scanner scanner);
    String stringInputValidation(Scanner scanner);
    Double doubleInputValidation(Scanner scanner);

}
