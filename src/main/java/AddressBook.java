import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            System.out.println("\nSelect an option:\n1. Add Contact\n2. Edit Contact\n3. Delete Contact\n4. Display Contact\n5. Search By City\n6. Search By State\n7. Sort the contacts by name\n8. Get count by city name\n10. Get Sort by city name\n11. Exit");
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
                    displayContact();
                    break;
                case 5:
                    searchByCity();
                    break;
                case 6:
                    searchByState();
                    break;
                case 7:
                    sortContactName();
                    break;
                case 8:
                    getCountByCity();
                    break;
                case 9:
                    getCountByState();
                    break;
                case 10:
                    sortByCity();
                    break;
                case 11:
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
        addContact(newContact);
    }

    public static void addContact(Contact newContact) {
        if (contactAddress.contains(newContact)) {
            System.out.println("Duplicate entry: " + newContact.getFullName());
        } else {
            contactAddress.add(newContact);
            System.out.println("Contact added successfully");
        }
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

    private static void displayContact() {
        contactAddress.stream().forEach(System.out::println);
    }

    private static void searchByCity() {
        System.out.println("Enter city name for the contact to see: ");
        String cityName = scanner.next();
        contactAddress.stream().filter(ct -> ct.getCity().equalsIgnoreCase(cityName))
                .forEach(x -> System.out.println(x.getFirstName()));
    }

    private static void searchByState() {
        System.out.println("Enter State Name of the contact you want to display: ");
        String stateName = scanner.next();
        contactAddress.stream().filter(st -> st.getState().equalsIgnoreCase(stateName))
                .forEach(System.out::println);
    }

    private static void sortContactName() {
        contactAddress.sort(Comparator.comparing(Contact::getFirstName));
        contactAddress.stream().forEach(System.out::println);
    }

    private static void getCountByCity() {
        HashSet<String> cities = new HashSet<>();
        for (Contact contact : contactAddress) {
            cities.add(contact.getCity());
        }
        System.out.println("There are " + cities + " unique cities in the list.");
        int count = 0;
        for (int i = 0; i < cities.size(); i++) {
            count++;
        }
        System.out.println("Total unique cities are: " + count);
    }


    private static void getCountByState() {
        HashSet<String> states = new HashSet<>();
        for (Contact contact : contactAddress) {
            states.add(contact.getCity());
        }
        System.out.println("There are " + states + " unique states in the list.");
        int count = 0;
        for (int i = 0; i < states.size(); i++) {
            count++;
        }
        System.out.println("Total unique states are: " + count);
    }

    public static void sortByCity() {
        contactAddress.sort(Comparator.comparing(Contact::getCity));
        contactAddress.stream().forEach(System.out::println);
    }

    public static void sortByState() {
        contactAddress.sort(Comparator.comparing(Contact::getState));
        contactAddress.stream().forEach(System.out::println);
    }

    public static void sortByZip() {
        contactAddress.sort(Comparator.comparing(Contact::getZip));
        contactAddress.stream().forEach(System.out::println);
    }
}