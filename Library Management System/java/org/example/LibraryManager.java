package org.example;

import java.util.Scanner;

public class LibraryManager {
    private final Scanner input;
    private final BookManager bookManager;
    private final LoanManager loanManager;
    private final MemberManager memberManager;

    public LibraryManager() {
        input = new Scanner(System.in);
        bookManager = new BookManager();
        loanManager = new LoanManager();
        memberManager = new MemberManager();
    }
    public void startProgram(){
        greeting();
        isAdmin();
        greetAdmin();
        pickSection();
    }

    private void greeting(){
        System.out.println();
        System.out.println("//////////  Welcome to Doo Library  \\\\\\\\\\\\\\\\\\\\");
        System.out.println();
        System.out.println("*** Please, Confirm your identity by entering correct username and password ***");
    }
    private void greetAdmin(){
        System.out.println("*** Welcome Our Admin. ***");
        System.out.println("*** Have a nice day ***");
    }

    private String getUsername(){
        System.out.print("Enter Username:");
        return input.next();
    }
    private String getPassword(){
        System.out.print("Enter Password:");
        return input.next();
    }
    private boolean isUsernameCorrect(String user){
        return user.equals("admin");
    }
    private boolean isPasswordCorrect(String pass){
        return pass.equals("123456");
    }
    private void isAdmin(){
        while (true){
            String user = getUsername();
            String pass = getPassword();
            if (isUsernameCorrect(user) && isPasswordCorrect(pass)) break;
            System.out.println("Username, Password or Both are incorrect.");
        }
    }

    private int getOperationNumber(){
        System.out.println("Choose Operation Number:");
        return input.nextInt();
    }
    private void pickSection(){
        boolean isFinished = false;
        while (!isFinished){
            System.out.println("""
                    Main Operations:
                    \t1- Book
                    \t2- Member
                    \t3- Loan
                    \t0- Exit""");
            int adminChoice = getOperationNumber();
            switch (adminChoice){
                case 1-> bookOperations();
                case 2-> memberOperations();
                case 3-> loanOperations();
                case 0 -> isFinished = true;
                default -> System.out.println("Invalid Operation Number.!");
            }
        }
    }

    private void loanOperations() {
        boolean isFinished = false;
        while (!isFinished){
            System.out.println("""
                        Loan Operations:
                        \t1- Add Loan
                        \t2- Search For Loan
                        \t0- Exit""");
            int operationNumber = getOperationNumber();
            switch (operationNumber){
                case 1-> loanManager.addLoan();
                case 2-> loanManager.searchLoanById();
                case 0 -> isFinished = true;
                default -> System.out.println("Invalid Operation Number.!");
            }
        }
    }

    private void memberOperations() {
        boolean isFinished = false;
        while (!isFinished){
            System.out.println("""
                        Member Operations:
                        \t1- Add Member
                        \t2- Delete Member
                        \t3- Search For Member
                        \t4- Update Member
                        \t0- Exit""");
            int operationNumber = getOperationNumber();
            switch (operationNumber){
                case 1-> memberManager.addMember();
                case 2-> memberManager.deleteMemberById();
                case 3-> memberManager.searchMemberById();
                case 4-> memberUpdateOperations();
                case 0 -> isFinished = true;
                default -> System.out.println("Invalid Operation Number.!");
            }
        }
    }
    private void memberUpdateOperations() {
        boolean isFinished = false;
        while (!isFinished){
            System.out.println("""
                        Member Update Operations:
                        \t1- Update Name
                        \t2- Update Phone
                        \t3- Update Email
                        \t4- Update Address
                        \t5- Update All Member Data
                        \t0- Exit""");
            int operationNumber = getOperationNumber();
            switch (operationNumber){
                case 1-> memberManager.updateMemberName();
                case 2-> memberManager.updateMemberPhoneNumber();
                case 3-> memberManager.updateMemberEmail();
                case 4-> memberManager.updateMemberAddress();
                case 5-> memberManager.updateMember();
                case 0 -> isFinished = true;
                default -> System.out.println("Invalid Operation Number.!");
            }
        }
    }

    private void bookOperations() {
        boolean isFinished = false;
        while (!isFinished){
            System.out.println("""
                        Book Operations:
                        \t1- Add Book
                        \t2- Delete Book
                        \t3- Search For Book
                        \t4- Update Book
                        \t0- Exit""");
            int operationNumber = getOperationNumber();
            switch (operationNumber){
                case 1-> bookManager.addBook();
                case 2-> bookDeleteOperations();
                case 3-> bookSearchOperations();
                case 4-> bookUpdateOperations();
                case 0 -> isFinished = true;
                default -> System.out.println("Invalid Operation Number.!");
            }
        }
    }
    private void bookUpdateOperations() {
        boolean isFinished = false;
        while (!isFinished){
            System.out.println("""
                        Book Update Operations:
                        \t1- Update Title
                        \t2- Update Author
                        \t3- Update Genre
                        \t4- Update Publication Year
                        \t5- Update Available Copies Number
                        \t6- Update All Book Data
                        \t0- Exit""");
            int operationNumber = getOperationNumber();
            switch (operationNumber){
                case 1-> bookManager.updateBookTitle();
                case 2-> bookManager.updateBookAuthorName();
                case 3-> bookManager.updateBookGenre();
                case 4-> bookManager.updateBookPublicationYear();
                case 5-> bookManager.updateBookAvailableCopies();
                case 6-> bookManager.updateBook();
                case 0 -> isFinished = true;
                default -> System.out.println("Invalid Operation Number.!");
            }
        }
    }
    private void bookSearchOperations() {
        boolean isFinished = false;
        while (!isFinished){
            System.out.println("""
                        Book Search Operations:
                        \t1- Search by ISBN
                        \t2- Search by Title
                        \t0- Exit""");
            int operationNumber = getOperationNumber();
            switch (operationNumber){
                case 1-> bookManager.searchBookByIsbn();
                case 2-> bookManager.searchBookByTitle();
                case 0 -> isFinished = true;
                default -> System.out.println("Invalid Operation Number.!");
            }
        }
    }
    private void bookDeleteOperations() {
        boolean isFinished = false;
        while (!isFinished){
            System.out.println("""
                        Book Delete Operations:
                        \t1- Delete by ISBN
                        \t2- Delete by Title
                        \t0- Exit""");
            int operationNumber = getOperationNumber();
            switch (operationNumber){
                case 1-> bookManager.deleteBookByIsbn();
                case 2-> bookManager.deleteBookByTitle();
                case 0 -> isFinished = true;
                default -> System.out.println("Invalid Operation Number.!");
            }
        }
    }


}
