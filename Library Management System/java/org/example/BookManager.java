package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookManager {
    private final Scanner input;
    private final QueryManager queryManager;
    private final Connection connection;

    public BookManager() {
        input = new Scanner(System.in);
        queryManager = new QueryManager("src/main/resources/queries.properties");
        connection = DbConnection.getInstance().getConnection();
    }

    public void addBook() {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("addBook"));
            statement.setString(1,getTitleFromUser());
            statement.setString(2,getAuthorNameFromUser());
            statement.setString(3,getPublicationYearFromUser());
            statement.setString(4,getGenreFromUser());
            statement.setInt(5,getAvailableCopiesFromUser());
            int affectedRows = statement.executeUpdate();
            System.out.println(affectedRows+" new Book Added to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBookByIsbn(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("deleteBookByIsbn"));
            statement.setInt(1,getIsbnFromUser());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) System.out.println("No such isbn found.!!");
            else System.out.println(rowsAffected+" book deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBookByTitle(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("deleteBookByTitle"));
            statement.setString(1,getTitleFromUser());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) System.out.println("No such isbn found.!!");
            else System.out.println(rowsAffected+" book deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchBookByIsbn(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("searchBookByIsbn"));
            statement.setInt(1,getIsbnFromUser());
            ResultSet resultSet =  statement.executeQuery();
            if (resultSet.next())
                System.out.println(new Book(resultSet.getInt(1)
                    , resultSet.getString(2)
                    , resultSet.getString(3)
                    , resultSet.getString(4)
                    , resultSet.getString(5)
                    , resultSet.getInt(6)));
            else System.out.println("Book not found.!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void searchBookByTitle(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("searchBookByTitle"));
            statement.setString(1,getTitleFromUser());
            ResultSet resultSet =  statement.executeQuery();
            if (resultSet.next())
                System.out.println(new Book(resultSet.getInt(1)
                    , resultSet.getString(2)
                    , resultSet.getString(3)
                    , resultSet.getString(4)
                    , resultSet.getString(5)
                    , resultSet.getInt(6)));
            else System.out.println("Book not found.!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateBookTitle(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateBookTitle"));
            statement.setInt(2,getIsbnFromUser());
            statement.setString(1,getTitleFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBookAuthorName(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateBookAuthor"));
            statement.setInt(2,getIsbnFromUser());
            statement.setString(1,getAuthorNameFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBookGenre(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateBookGenre"));
            statement.setInt(2,getIsbnFromUser());
            statement.setString(1,getGenreFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBookPublicationYear(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateBookPublicationYear"));
            statement.setInt(2,getIsbnFromUser());
            statement.setString(1,getPublicationYearFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBookAvailableCopies(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateBookAvailableCopies"));
            statement.setInt(2,getIsbnFromUser());
            statement.setInt(1,getAvailableCopiesFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBook(){
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(queryManager.getQuery("updateBook"));
            statement.setInt(6,getIsbnFromUser());
            statement.setString(1,getTitleFromUser());
            statement.setString(2,getAuthorNameFromUser());
            statement.setString(3,getPublicationYearFromUser());
            statement.setString(4,getGenreFromUser());
            statement.setInt(5,getAvailableCopiesFromUser());
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected+" Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getIsbnFromUser() {
        // Using try-catch to handle mismatch data type
        int isbn;
        while (true){
            System.out.print("Enter book's ISBN:");
            try {
                isbn = input.nextInt();
                if (isValidNumber(isbn)) break;
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }catch (Exception e){
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }

        }
        return isbn;
    }
    private String getTitleFromUser(){
        String title;
        while (true){
            System.out.print("Enter book's title:");
            title = input.nextLine();
            if (isValidTitle(title)) break;
            System.out.println("Invalid book title, Please try enter a valid title.");
        }
        return title;
    }
    private String getAuthorNameFromUser(){
        String name;
        while (true){
            System.out.print("Enter author's name:");
            name = input.nextLine();
            if (isValidAuthorName(name)) break;
            System.out.println("Invalid author name, Please try enter a valid name.");
        }
        return name;
    }
    private String getGenreFromUser(){
        String genre;
        while (true){
            input.nextLine();
            System.out.print("Enter book's genre:");
            genre = input.nextLine();
            if (isValidGenre(genre)) break;
            System.out.println("Invalid book genre, Please try enter a valid genre.");
        }
        return genre;
    }
    private String getPublicationYearFromUser(){
        String year;
        while (true){
            System.out.print("Enter book's publication year:");
            year = input.next();
            if (isValidYear(year)) break;
            System.out.println("Invalid book's publication year, Please try enter a valid year (1800-2024).");
        }
        return year;
    }
    private int getAvailableCopiesFromUser(){
        // Using try-catch to handle mismatch data type
        int availableCopies;
        while (true){
            System.out.print("Enter book's available copies:");
            try {
                availableCopies = input.nextInt();
                if (isValidNumber(availableCopies)) break;
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }catch (Exception e){
                System.out.println("Invalid  number, Please try enter a valid int positive number.");
            }

        }
        return availableCopies;
    }

    private boolean isValidTitle(String title) {
        return title.matches("^[A-Za-z0-9@#$_&!?\\s.,;:()'\"-]+$");
    }
    private boolean isValidAuthorName(String name) {
        return name.matches("^[A-Za-z]+(?:\\s+[A-Za-z]+)*$");
    }
    private boolean isValidGenre(String genre) {
        //Make sure that the book's genre is one of these genres only
        return genre.toLowerCase().matches("^(fantasy|science fiction|mystery|romance|horror|thriller|historical|war)$");
    }
    private boolean isValidNumber(int number) {
        //Make sure that number of copies is a positive int number
        return String.valueOf(number).matches("^\\d+$");
    }
    private boolean isValidYear(String year){
        //Make sure that the year of publication is between 1800-2024
        return year.matches("^(18[0-9]{2}|19[0-9]{2}|20[0-2][0-4])$");
    }

}
