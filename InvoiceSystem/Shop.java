package InvoiceSystem;

import java.util.*;

public class Shop {
    static Scanner scanner = new Scanner(System.in);
    private Integer id; //class ID
    private String name; //shop name
    private static Map<String, String> header; //shop header
    public static List<Item> items = new ArrayList<>();
    public static List<Invoice> invoices = new ArrayList<>();

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> items) {
        Shop.items = items;
    }

    public static List<Invoice> getInvoices() {
        return invoices;
    }

    public static void setInvoices(List<Invoice> invoices) {
        Shop.invoices = invoices;
    }

    //methods related to shop
    //method to load data (option 1 in Shop Settings Menu)
    static void loadData() {
        System.out.println("Loading Data . .");
        //instances of Item Class
        Item firstItem = new Item(7, "Bread", 1.0, 2);
        Item secondItem = new Item(9, "Cheese", 2.0, 3);

        //adding items to the item list
        items.add(firstItem);
        items.add(secondItem);

        //instance of Invoice Class
        Invoice invoice = new Invoice(9, "Noura", "3342454", "25-04-2024", items, firstItem.totalAmount(2, 1.0));

        //adding invoice to invoice list
        invoices.add(invoice);

        System.out.println("Data loaded successfully");

    }

    //method to set shop name (option 2 in Shop Settings Menu)
    static void setShopName() {
        Shop shop = new Shop();
        System.out.println("\nEnter new shop name: ");
        String newShopName = scanner.nextLine();
        System.out.println("Shop Name: " + newShopName); //setting the new name
        shop.setName(newShopName);
    }

    //method to set invoice header (option 3 in Shop Settings Menu)
    static void setInvoiceHeader() {
        System.out.println("\nEnter new invoice header:");
        System.out.print("Tel: ");
        String telNumber = scanner.nextLine();
        header.put("Phone number", telNumber);
        System.out.print("Fax: ");
        String fax = scanner.nextLine();
        header.put("Fax", fax);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        header.put("Email", email);
        System.out.print("Website: ");
        String website = scanner.nextLine();
        header.put("Website", website);
        //setting shop header
        System.out.println("\nInvoice header set to: Tel: " +
                telNumber + " | Fax: " + fax + " | Email " +
                email + " | Website: " + website);
    }

    //method to add invoice to the list
    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

    //method for validation check
    public Integer inputValidation(Scanner scanner) {
        Integer invoiceID = null;
        Boolean isValid = Boolean.TRUE;
        while (isValid) {
            try {
                invoiceID = scanner.nextInt();
                if (invoiceID <= 0) {
                    System.out.println("Invalid invoice ID. Please enter a positive integer:");
                    //continue; //continue the loop to prompt for input again
                } else {
                    break; //exit the loop if a valid ID is entered
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer:");
                scanner.nextLine(); //consuming the invalid input
            }
        }
        return invoiceID;
    }

    // equals(), hashCode() and toString() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) && Objects.equals(header, shop.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, header);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", header=" + header +
                '}';
    }
}