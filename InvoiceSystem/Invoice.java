package InvoiceSystem;

import java.util.List;
import java.util.Objects;

public class Invoice {
    private Integer id; //class ID
    private Integer invoiceID; //invoice ID
    private String costumerName;
    private String phoneNumber; //costumer phone number
    private String date; //invoice date
    private List<Item> itemList;
    private Double totalAmount;
    private Double paidAmount;
    private Double balance;

    //constructor

    public Invoice() {
    }

    public Invoice(Integer invoiceID, String costumerName, String phoneNumber, String date, List<Item> itemList, Double totalAmount) {
        this.invoiceID = invoiceID;
        this.costumerName = costumerName;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.itemList = itemList;
        this.totalAmount = totalAmount;
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Integer invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    //methode to calculate total amount of invoice
    public Double totalAmount(List<Item> itemList) {

        /* Error Handling */
        if (itemList == null || itemList.isEmpty()) { //if item list is empty
            //prompting user that item list is empty
            System.out.println("\nError: Item list is empty. Cannot calculate total amount.");
            return 0.0; //quitting method
        }

        double total = 0.0;
        for (Item item : itemList) {
            //checking each item
            if (item != null) {
                //validating item quantity and price
                if (item.getQuantity() != null && item.getUnitPrice() != null) {
                    total = total + (item.getUnitPrice() * item.getQuantity());
                } else {
                    //null item data (price, quantity)
                    System.out.println("Error: Invalid item data found. Skipping calculation for this item.");
                }
            } else {
                //null item
                System.out.println("Error: Null item found in itemList. Skipping calculation for this item.");
            }
        }

        return total;
    }

    //method to update balance
    public void updateBalance() {
        this.balance = this.totalAmount - this.paidAmount;
    }

    //equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceID, invoice.invoiceID);
    }

    //hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(invoiceID);
    }

    //toString()
    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceID=" + invoiceID +
                ", costumerName='" + costumerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", date='" + date + '\'' +
                ", itemList=" + itemList +
                ", totalAmount=" + totalAmount +
                ", payedAmount=" + paidAmount +
                ", balance=" + balance +
                '}';
    }
}
