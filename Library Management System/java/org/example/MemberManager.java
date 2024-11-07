package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberManager {
    private final Scanner input;
    private final QueryManager queryManager;
    private final Connection connection;

    public MemberManager() {
        input = new Scanner(System.in);
        queryManager = new QueryManager("src/main/resources/queries.properties");
        connection = DbConnection.getInstance().getConnection();
    }

    public void addMember() {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("addMember"));
            statement.setString(1,getMemberNameFromUser());
            statement.setString(2,getAddressFromUser());
            statement.setString(3,getPhoneNumberFromUser());
            statement.setString(4,getEmailFromUser());
            statement.setString(5,getMembershipDate());
            int affectedRows = statement.executeUpdate();
            System.out.println(affectedRows+" new Member Added to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteMemberById(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("deleteMemberById"));
            statement.setInt(1,getIdFromUser());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) System.out.println("No such id found.!!");
            else System.out.println(rowsAffected+" member deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchMemberById(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("searchMemberById"));
            statement.setInt(1,getIdFromUser());
            ResultSet resultSet =  statement.executeQuery();
            if (resultSet.next())
                System.out.println(new Member(resultSet.getInt(1)
                        , resultSet.getString(2)
                        , resultSet.getString(3)
                        , resultSet.getString(4)
                        , resultSet.getString(5)
                        , resultSet.getString(6)));
            else System.out.println("Member not found.!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateMemberName(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateMemberName"));
            statement.setInt(2,getIdFromUser());
            statement.setString(1,getMemberNameFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" member updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMemberPhoneNumber(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateMemberPhone"));
            statement.setInt(2,getIdFromUser());
            statement.setString(1,getPhoneNumberFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" member updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMemberEmail(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateMemberEmail"));
            statement.setInt(2,getIdFromUser());
            statement.setString(1,getEmailFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" member updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMemberAddress(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateMemberAddress"));
            statement.setInt(2,getIdFromUser());
            statement.setString(1,getAddressFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" member updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMember(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateMember"));
            statement.setInt(5,getIdFromUser());
            statement.setString(1,getMemberNameFromUser());
            statement.setString(2,getAddressFromUser());
            statement.setString(3,getPhoneNumberFromUser());
            statement.setString(4,getEmailFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" member updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getIdFromUser() {
        // Using try-catch to handle mismatch data type
        int id;
        while (true){
            input.nextLine();
            System.out.print("Enter member's ID:");
            try {
                id = input.nextInt();
                if (isValidIntNumber(id)) break;
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }catch (Exception e){
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }

        }
        return id;
    }
    private String getMemberNameFromUser(){
        String name;
        while (true){
            System.out.print("Enter member's name:");
            name = input.nextLine();
            if (isValidMemberName(name)) break;
            System.out.println("Invalid name, Please try enter a valid name.");
        }
        return name;
    }
    private String getPhoneNumberFromUser(){
        String phone;
        while (true){
            System.out.print("Enter member's phone number:");
            phone = input.nextLine();
            if (isValidEgyptianPhone(phone)) break;
            System.out.println("Invalid Egyptian phone number, Please try enter a valid number.");
        }
        return phone;
    }
    private String getEmailFromUser(){
        String email;
        while (true){
            System.out.print("Enter member's email :");
            email = input.nextLine();
            if (isValidEmail(email)) break;
            System.out.println("Invalid gmail account, Please try enter a valid gmail account.");
        }
        return email;
    }
    private String getAddressFromUser(){
        String address;
        while (true){
            System.out.print("Enter member's address :");
            address = input.nextLine();
            if (isValidAddress(address)) break;
            System.out.println("Invalid address, Please try enter a valid address.");
        }
        return address;
    }
    private String getMembershipDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return today.format(formatter);
    }

    private boolean isValidMemberName(String name) {
        return name.matches("^[A-Za-z]+(?:\\s+[A-Za-z]+)*$");
    }
    private boolean isValidEgyptianPhone(String name) {
        // Egyptian Phone Numbers Only
        return name.matches("^01[0125][0-9]{8}$");
    }
    private boolean isValidEmail(String name) {
        // Gmail Accounts Only
        return name.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$");
    }
    private boolean isValidAddress(String name) {
        /*
        Example Matches:
            123 Main Street, Cairo
            456 Oak Avenue, New York
            789 Elm Road
        */
        return name.matches("^\\d+\\s[A-Za-z\\s]+\\s[A-Za-z\\s]*(?:,\\s[A-Za-z\\s]+)?$");
    }
    private boolean isValidIntNumber(int number) {
        //Make sure that number of copies is a positive int number
        return String.valueOf(number).matches("^\\d+$");
    }





}
