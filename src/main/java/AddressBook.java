import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private String name;
    private static ArrayList<Contact> contactAddress = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public AddressBook(String name) {
        this.name = name;
    }

    public void run() {
        boolean flag = true;
        while (flag) {
            System.out.println("\nSelect an option:\n1. Add Contact\n2. Edit Contact\n3. Delete Contact\n4. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
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
        contactAddress.add(newContact);
        System.out.println("Contact Added Successfully.");
    }

    private static void editContact() {
        System.out.println("Enter First Name of the contact you want to edit: ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name of the contact you want to edit: ");
        String lastName = scanner.next();
        boolean found = false;
        for (Contact contact : contactAddress) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                System.out.println("Enter new Address: ");
                String address = scanner.next();
                System.out.println("Enter new City: ");
                String city = scanner.next();
                System.out.println("Enter new State: ");
                String state = scanner.next();
                System.out.println("Enter new Zip: ");
                int zip = scanner.nextInt();
                System.out.println("Enter new Phone Number: ");
                long phoneNumber = scanner.nextLong();
                System.out.println("Enter new Email: ");
                String email = scanner.next();
                contact.setAddress(address);
                contact.setCity(city);
                contact.setState(state);
                contact.setZip(zip);
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);
                found = true;
                System.out.println("Contact Edited Successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact() {
        System.out.println("Enter First Name of the contact you want to delete: ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name of the contact you want to delete: ");
        String lastName = scanner.next();
        boolean found = false;
        for (Contact contact : contactAddress) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                contactAddress.remove(contact);
                found = true;
                System.out.println("Contact Deleted Successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}