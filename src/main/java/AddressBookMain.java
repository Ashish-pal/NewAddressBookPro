import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


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
            createAddressBookFile(name);
        }
    }

    private static void createAddressBookFile(String fileName) {
        try {
            File file = new File(fileName + ".json");
            if (file.createNewFile()) {
                System.out.println("File created: " + fileName + ".json");
            } else {
                System.out.println("File already exists: " + fileName + ".json");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
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
                saveAddressBookToFile(name);
            } else {
                System.out.println("\nThe address book " + name + " does not exist.");
            }
        }
    }

    private static void saveAddressBookToFile(String fileName) {
        try {
            AddressBook addressBook = addressBooks.get(fileName);
            ArrayList<Contact> contacts = addressBook.getContactAddress();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(contacts);

            FileWriter fileWriter = new FileWriter(fileName + ".json");
            fileWriter.write(json);
            fileWriter.close();

            System.out.println("Address book saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the address book to file.");
            e.printStackTrace();
        }
    }
}