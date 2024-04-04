package InvoiceSystem;

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
    }
}
