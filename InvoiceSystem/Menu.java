package InvoiceSystem;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    //method to display and handle main menu
    public Integer displayMainMenu(){
        System.out.println("\n:::Menu:::\nSelect option:");
        System.out.println("1. Shop Settings");
        System.out.println("2. Manage Shop Items");
        System.out.println("3. Create New Invoice");
        System.out.println("4. Report: Statistics");
        System.out.println("5. Report: All Invoices");
        System.out.println("6. Search Invoices");
        System.out.println("7. Program Statistics");
        System.out.println("8. Exit");

        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    //method to display and handle shop settings menu
    public Integer displayShopSettingsMenu(){
        System.out.println("Shop Settings:");
        System.out.println("1. Load Data (Items and invoices)");
        System.out.println("2. Set Shop Name");
        System.out.println("3. Set Invoice Header");
        System.out.println("4. Go Back");

        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    //method to display and handle manage shop items menu
    public Integer displayManageItemsMenu(){
        System.out.println("Manage Shop Items:");
        System.out.println("1. Add Items");
        System.out.println("2. Delete Items");
        System.out.println("3. Change Item Price");
        System.out.println("4. Report All Items");
        System.out.println("5. Go Back");

        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    //method to display and handle program statistics
    public Integer displayProgramStatisticsMenu(){
        System.out.println("Program Statistics:");
        System.out.println("1. Show Menu Usage Statistics");
        System.out.println("2. Go Back");

        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
}
