package InvoiceSystem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoicingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Menu mainMenu = new Menu(); //instance of Menu class

    //Lists to store invoiced and items
    private static List<Item> items = new ArrayList<>();
    private static List<Invoice> invoices = new ArrayList<>();

    public static void main(String[] args) {
        Boolean exit = Boolean.FALSE;
        while (!exit){
            //display main menu from Menu class
            Integer option = mainMenu.displayMainMenu();

            switch (option){
                case 1:
                    handleShopSetting();
                    break;
                case 2:
                    handleManageItems();
                    break;
                case 3:
                    createInvoice();
                     break;
                case 4:
                    reportItemStatistics();
                    break;
                case 5:
                    reportAllInvoices();
                    break;
                case 6:
                    searchInvoices();
                    break;
                case 7:
                    handleProgramStatistics();
                    break;
                case 8:
                    exit = confirmExit();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
        System.out.println("Exiting Invoicing System. Bye!");
        scanner.close();
    }

    //method to handle option 1 (Shop Settings)
    private static void handleShopSetting(){
        Boolean back = Boolean.FALSE;

        while (!back){

            Integer option = mainMenu.displayShopSettingsMenu();

            switch (option){
                case 1:
                    loadData(); //implementing Load Data functionality
                    break;
                case 2:
                    setShopName(); //implementing Set Shop Name functionality
                    break;
                case 3:
                    setInvoiceHeader(); // Implement Set Invoice Header functionality
                    break;
                case 4:
                    back = Boolean.TRUE;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    //method to load data (option 1 in Shop Settings Menu)
    private static void loadData(){
        System.out.println("Loading Data . .");
        //action of loading data

    }

    //method to set shop name (option 2 in Shop Settings Menu)
    private static void setShopName(){
        System.out.println("\nEnter new shop name: ");
        String newShopName = scanner.nextLine();
        System.out.println("Shop Name: " + newShopName); //setting the new name
    }

    //method to set invoice header (option 3 in Shop Settings Menu)
    private static void setInvoiceHeader(){
        System.out.println("\nEnter new invoice header:");
        System.out.print("Tel: ");
        String telNumber = scanner.nextLine();
        System.out.print("Fax: ");
        String fax = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Website: ");
        String website = scanner.nextLine();
        //setting shop header
        System.out.println("\nInvoice header set to: Tel: " +
                            telNumber + " | Fax: " + fax + " | Email " +
                            email + " | Website: " + website);
    }

    //method to handle option 2 in Main Menu (Manage Shop Items)
    private static void handleManageItems(){
        Boolean back = Boolean.FALSE;

        while (!back){

            Integer option = mainMenu.displayManageItemsMenu();

            switch (option){
                case 1:
                    addItem(); //adding item
                    break;
                case 2:
                    deleteItem(); //deleting item
                    break;
                case 3:
                    changeItemPrice(); //changing item price
                    break;
                case 4:
                    reportAllItems(); //report all items
                    break;
                case 5:
                    back = Boolean.TRUE;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    //method to add items (option 1 in Manage Items Menu)
    private static void addItem(){
        System.out.println("Adding Item . .");

        //asking user to enter item details
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item ID: ");
        Integer itemID = scanner.nextInt();
        scanner.nextLine(); //consuming newline character after reading Integer
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter unit price: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Item newItem = new Item(itemID, name, unitPrice, quantity);
        items.add(newItem); //adding the item to the items list

        System.out.println("Item Added Successfully..");
    }

    //method to delete items (option 2 in Manage Items Menu)
    private static void deleteItem(){
        System.out.println("Deleting Item . .");
        //asking user to select and delete an item from the items list
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item ID to delete: ");
        Integer deleteItem = Integer.valueOf(scanner.next());

        //finding and removing the item from the items list
        Boolean isFound = Boolean.FALSE;
        Item itemToRemove = null;

        for (Item item : items){
            if (item != null && item.getItemID() != null && item.getItemID().equals(deleteItem)){
                itemToRemove = item;
                isFound = Boolean.TRUE;
                break;
            }
        }
        if (isFound){
            items.remove(itemToRemove);
            System.out.println("Item deleted successfully");
        }else {
            System.out.println("Item with ID " + deleteItem + " not found");
        }
    }

    //method to change item price (option 3 in Manage Items Menu)
    private static void changeItemPrice(){
        System.out.println("Updating Price . .");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item ID to update the price: ");
        Integer updatePrice = Integer.valueOf(scanner.next());

        Boolean isFound = Boolean.FALSE;


        for (Item item : items){
            if (item.getItemID().equals(updatePrice)){
                System.out.println("Enter new price: ");
                Double newPrice = scanner.nextDouble();

                //updating the price
                item.setUnitPrice(newPrice);
                System.out.println("Item price updated successfully");

                isFound = Boolean.TRUE;
                break;
            }
        }
        if (!isFound){
            System.out.println("Item with ID " + updatePrice + " not found");
        }

    }

    //method to report all items (option 4 in Manage Items Menu)
    private static void reportAllItems(){
        System.out.println("Reporting All Items . .");
        //displaying report of all items in items list
        if (items.isEmpty()){
            System.out.println("No items available");
        } else {
            System.out.println("List of items: ");
            for (Item item : items){
                System.out.println(item);
            }
        }
    }

    //method to handle option 3 in Main Menu (create nwe invoice)
    private static void createInvoice(){
        System.out.println("Creating New Invoice . .");
        //asking user to input invoice details + adding it to invoices list
    }

    //method to handle option 4 in Main Menu (Report Item Statistics)
    private static void reportItemStatistics(){
        System.out.println("Displaying statistics...");
    }
    //method to handle option 5 in Main Menu (Report All Invoices)
    private static void reportAllInvoices(){
        System.out.println("Displaying All Invoices...");
        //action of displaying report
    }

    //method to handle option 6 in Main Menu (Search Invoices)
    private static void searchInvoices(){
        System.out.println("Searching Invoices . .");
        //asking user to enter ID of invoice
        //action of search
    }

    //method to handle option 7 in Main Menu (Program Statistics)
    private static void handleProgramStatistics(){
        System.out.println("Displaying Program Statistics...");
        //action of displaying program statistics
    }

    //method to handle option 8 in Main Menu (Exit)
    private static Boolean confirmExit(){
        System.out.print("Are you sure you want to exit? (yes/no): ");
        String confirmOption = scanner.nextLine();
        return confirmOption.equalsIgnoreCase("yes");
    }

}
