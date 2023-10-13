import java.util.*;

public class Note {
    private static final Scanner input = new Scanner(System.in);
    private int contactsCounter = 0; // used as contact id and the key to it in the map
    private final HashMap<Integer, Contact> contacts = new HashMap<>(); // to store contacts' data

    // The method that manage all operations at the note
    protected void openNote(){
        greeting();
        while (true){
            String userChoice = getUserOperationChoice();
            if (userChoice.equals("0")) break;
            input.nextLine(); // Consume the newline character stored in the buffer
            switch (userChoice){
                case "1" -> addContact();
                case "2" -> updateContact(getId());
                case "3" -> deleteContact(getId());
                case "4" -> showContactById(getId());
                case "5" -> showContacts();
                default -> System.out.println("Not An Option, Choose Again");
            }
        }
    }

    // Basic operation's methods
    private void addContact(){
        contactsCounter++;
        Contact contact = new Contact();
        contact.setName(getContactName());
        contact.setPhoneNumber(getContactPhone());
        contact.setEmail(getContactEmail());
        contact.setAddress(getContactAddress());
        contacts.put(contactsCounter,contact);
        System.out.println("+++++ Contact Saved Successfully +++++");
    }
    private void deleteContact(int id){
        // If you want to exit from this option just enter 0
        while (id != 0){
            if (contacts.isEmpty()){
                System.out.println("**** Your note is empty, No Contacts to Delete..! ****");
                break;
            }
            else if(contacts.containsKey(id)){
                contacts.remove(id);
                System.out.println("----- Contact Removed Successfully -----");
                break;
            }else{
                System.out.println("#### Contact ID not found..! ####");
                id = getId();
            }
        }
    }
    private void updateContact(int id){
        // If you want to exit from this option just enter 0
        while (id != 0){
            if (id == 9) id = getId();
            if(contacts.containsKey(id)){
                System.out.println("Contact to be updated....");
                showContactById(id);

                String choice = getUserChoiceForUpdate();
                if (choice.equals("9")) {
                    id = 9;
                    continue;
                }
                else if (choice.equals("0")){
                    System.out.println("**** Operation Canceled ****");
                    break;
                }

                input.nextLine(); // Consume the newline character stored in the buffer

                switch (choice){
                    case "1":
                        updateContactName(id);
                        break;
                    case "2":
                        updateContactPhone(id);
                        break;
                    case "3":
                        updateContactEmail(id);
                        break;
                    case "4":
                        updateContactAddress(id);
                        break;
                    case "5":
                        updateContactName(id);
                        updateContactPhone(id);
                        updateContactEmail(id);
                        updateContactAddress(id);
                        break;
                    default:
                        System.out.println("Not An Option, Choose Again");
                }
                System.out.println("++++ Contact Updated Successfully ++++");
                showContactById(id);
                break;
            }else{
                System.out.println("#### Contact ID not found..! ####");
                id = getId();
            }
        }
    }
    private void showContacts(){
        if (contacts.isEmpty()){
            System.out.println("**** No Contacts to show..! ****");
        }
        else{
            System.out.println("$$$ All Contacts Info $$$");
            for (Integer k : contacts.keySet()) {
                Contact c = contacts.get(k);
                System.out.println("ID: " + k);
                System.out.println("\tName: "+c.getName());
                System.out.println("\tPhone Number: "+c.getPhoneNumber());
                System.out.println("\tEmail: "+c.getEmail());
                System.out.println("\tAddress: "+c.getAddress());
            }
        }
        System.out.println();
    }
    private void showContactById(int id){
        while (id != 0){
            if(contacts.containsKey(id)) {
                Contact c = contacts.get(id);
                System.out.println("ID: " + id);
                System.out.println("\tName: "+c.getName());
                System.out.println("\tPhone Number: "+c.getPhoneNumber());
                System.out.println("\tEmail: "+c.getEmail());
                System.out.println("\tAddress: "+c.getAddress());
                break;
            }else{
                System.out.println("#### Wrong Contact ID ####");
                id = getId();
            }
        }
    }

    // Helpful methods for the basic operations
    private int getId(){
        System.out.print("Enter Contact ID: ");
        return input.nextInt();
    }
    private String getContactName(){
        System.out.print("Enter Contact Name: ");
        return input.nextLine();
    }
    private String getContactPhone(){
        System.out.print("Enter Phone Number: ");
        return input.nextLine();
    }
    private String getContactEmail(){
        System.out.print("Enter Email: ");
        return input.nextLine();
    }
    private String getContactAddress(){
        System.out.print("Enter Address: ");
        return input.nextLine();
    }
    private String getUserChoiceForUpdate(){
        System.out.println("""
                Enter your choice:
                \t1- Update Name
                \t2- Update Phone Number
                \t3- Update Email
                \t4- Update Address
                \t5- Update All
                \t0- Cancel
                \t9- Enter anther ID""");
        return input.next();
    }
    private void updateContactName(int id){
        System.out.println("Enter New Name: ");
        contacts.get(id).setName(input.nextLine());
    }
    private void updateContactPhone(int id){
        System.out.println("Enter New Phone Number: ");
        contacts.get(id).setPhoneNumber(input.nextLine());
    }
    private void updateContactEmail(int id){
        System.out.println("Enter New Email: ");
        contacts.get(id).setEmail(input.nextLine());
    }
    private void updateContactAddress(int id){
        System.out.println("Enter New Address: ");
        contacts.get(id).setAddress(input.nextLine());
    }

    // Helpful methods for the openNote method
    private void greeting(){
        System.out.println("^^^^ Welcome to Contacts Note ^^^^");
    }
    private String getUserOperationChoice(){
        System.out.println("""
                1- Add New Contact.
                2- Update Contact.
                3- Delete Contact.
                4- Show Contact by ID.
                5- Show All Contacts.
                0- Exit Contacts Note App.
                """);
        System.out.print("  Operation Number: ");
        return input.next();
    }

}
