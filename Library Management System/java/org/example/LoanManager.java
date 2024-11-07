package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LoanManager {
    private final Scanner input;
    private final QueryManager queryManager;
    private final Connection connection;

    public LoanManager() {
        input = new Scanner(System.in);
        queryManager = new QueryManager("src/main/resources/queries.properties");
        connection = DbConnection.getInstance().getConnection();
    }

    public void addLoan(){
        try {
            int isbn;
            int id;
            while (true){
                isbn = getIsbnFromUser();
                if (isIsbnExist(isbn)) break;
                System.out.println("Book's ISBN doesn't exist.!");
            }
            while (true){
                id = getIdFromUser();
                if (isIdExist(id)) break;
                System.out.println("Member's ID doesn't exist.!");
            }
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("addLoan"));
            statement.setInt(1,id);
            statement.setInt(2,isbn);
            statement.setString(3,getLoanDate());
            statement.setString(4,getDueDate());
            statement.setString(5,"On Time");
            int affectedRows = statement.executeUpdate();
            System.out.println(affectedRows+" new Loan added to database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchLoanById(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("searchLoanById"));
            statement.setInt(1,getLoanIdFromUser());
            ResultSet resultSet =  statement.executeQuery();
            if (resultSet.next())
                System.out.println(new Loan(resultSet.getInt(1)
                        , resultSet.getInt(2)
                        , resultSet.getInt(3)
                        , resultSet.getString(4)
                        , resultSet.getString(5)
                        , resultSet.getString(6)));
            else System.out.println("Loan's ID not found.!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getLoanIdFromUser() {
        // Using try-catch to handle mismatch data type
        int id;
        while (true){
            System.out.print("Enter loan's ID:");
            try {
                id = input.nextInt();
                if (isValidNumber(id)) break;
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }catch (Exception e){
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }

        }
        return id;
    }
    private int getIsbnFromUser() {
        // Using try-catch to handle mismatch data type
        int isbn;
        while (true){
            System.out.print("Enter book's ISBN:");
            try {
                input.nextLine();
                isbn = input.nextInt();
                if (isValidNumber(isbn)) break;
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }catch (Exception e){
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }

        }
        return isbn;
    }
    private int getIdFromUser() {
        // Using try-catch to handle mismatch data type
        int id;
        while (true){
            System.out.print("Enter member's ID:");
            try {
                input.nextLine();
                id = input.nextInt();
                if (isValidNumber(id)) break;
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }catch (Exception e){
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }

        }
        return id;
    }
    private String getLoanDate(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return today.format(formatter);
    }
    private String getDueDate(){
        LocalDate today = LocalDate.now();
        LocalDate dateAfter7Days = today.plusDays(7);  // Add 7 days
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateAfter7Days.format(formatter);
    }

    private boolean isIsbnExist(int isbn){
        int isExist = 0;
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("findIsbn"));
            statement.setInt(1,isbn);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            isExist = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist == 1;
    }
    private boolean isIdExist(int id){
        int isExist = 0;
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("findId"));
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            isExist = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist == 1;
    }

    private boolean isValidNumber(int number) {
        //Make sure that number of copies is a positive int number
        return String.valueOf(number).matches("^\\d+$");
    }

}
