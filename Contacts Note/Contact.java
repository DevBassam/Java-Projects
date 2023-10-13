import java.util.Scanner;
import java.util.regex.*;
public class Contact {
    private static final Scanner input = new Scanner(System.in);
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String regex = "^[A-Z][a-zA-Z]{7,24}$";
        Pattern pattern = Pattern.compile(regex);
        while (true){
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()){
                this.name = name;
                break;
            }else {
                System.out.println("Invalid Person Name...");
                System.out.println("Enter a person's name starting with an uppercase letter, containing 8 to 25 characters. Use only letters (A-Z, a-z).");
                System.out.print("Try Again: ");
                name = input.next();
            }
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String regex = "^(01[0125])\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        while (true){
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.matches()){
                this.phoneNumber = phoneNumber;
                break;
            }else {
                System.out.println("Invalid Egyptian Phone Number...");
                System.out.println("Enter a valid Egyptian phone number starting with 010, 011, 012, or 015, followed by 8 digits (e.g., 01123456789).");
                System.out.print("Try Again: ");
                phoneNumber = input.next();
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        while (true){
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                this.email = email;
                break;
            }else {
                System.out.println("Invalid Email...");
                System.out.println("Enter a valid email address (e.g., example@example.com) using letters, numbers, and common symbols (@ . _ % + -).");
                System.out.print("Try Again: ");
                email = input.next();
            }
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
