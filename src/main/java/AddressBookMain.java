import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contact> addressBook = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        boolean flag = true;
        while (flag) {
            System.out.println("\nSelect an option:\n1. Add Contact\n2. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again");
                    break;
            }
        }
    }

    private static void addContact() {
        System.out.println("Enter First Name: ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();
        System.out.println("Enter Address: ");
        String address = scanner.next();
        System.out.println("Enter City: ");
        String city = scanner.next();
        System.out.println("Enter State: ");
        String state = scanner.next();
        System.out.println("Enter Zip: ");
        int zip = scanner.nextInt();
        System.out.println("Enter Phone Number: ");
        long phoneNumber = scanner.nextLong();
        System.out.println("Enter Email: ");
        String email = scanner.next();

        Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        addressBook.add(newContact);
        System.out.println("Contact Added Successfully.");
    }
}