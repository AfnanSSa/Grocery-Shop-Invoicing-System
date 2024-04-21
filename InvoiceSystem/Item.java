package InvoiceSystem;

import java.util.Objects;

public class Item {
    private Integer id; //class ID
    private Integer itemID; //item ID
    private String name; //item name
    private Double unitPrice;
    private Integer quantity;

    //method to calculate total amount
    public Double totalAmount(Integer quantity, Double unitPrice){
        return quantity * unitPrice;
    }

    public Item(Integer itemID, String name, Double unitPrice, Integer quantity) {
        this.itemID = itemID;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    //equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemID, item.itemID);
    }

    //hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(itemID);
    }

    //toString()
    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }
}
