import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    static Scanner scanner = new Scanner(System.in);

    private static HashMap<String, AddressBook> addressBooks = new HashMap<String, AddressBook>();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add an address book");
            System.out.println("2. Select an address book");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addAddressBook();
                    break;
                case 2:
                    selectAddressBook();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addAddressBook() {
        System.out.println("\nEnter the name of the address book:");
        String name = scanner.next();

        if (addressBooks.containsKey(name)) {
            System.out.println("\nThe address book " + name + " already exists.");
        } else {
            AddressBook addressBook = new AddressBook(name);
            addressBooks.put(name, addressBook);
            System.out.println("\nThe address book " + name + " has been added to the system.");
        }
    }

    private static void selectAddressBook() {
        if (addressBooks.size() == 0) {
            System.out.println("\nThere are no address books in the system.");
        } else {
            System.out.println("\nEnter the name of the address book you want to select: ");
            String name = scanner.next();

            if (addressBooks.containsKey(name)) {
                AddressBook addressBook = addressBooks.get(name);
                addressBook.run();
            } else {
                System.out.println("\nThe address book " + name + " does not exist.");
            }
        }
    }
}