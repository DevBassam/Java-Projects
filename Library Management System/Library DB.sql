CREATE DATABASE LibraryDB;

USE LibraryDB;

-- Table for Books
CREATE TABLE Books (
    ISBN INT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL,
    PublicationYear YEAR,
    Genre VARCHAR(100),
    NumberOfCopies INT DEFAULT 1,
    AvailableCopies INT DEFAULT 1
);

-- Table for Members
CREATE TABLE Members (
    MemberID INT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Address VARCHAR(255),
    PhoneNumber VARCHAR(20),
    Email VARCHAR(100),
    MembershipDate DATE
);

-- Table for Loans
CREATE TABLE Loans (
    LoanID INT AUTO_INCREMENT PRIMARY KEY,
    MemberID INT,
    ISBN INT,
    LoanDate DATE,
    DueDate DATE,
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID) ON DELETE CASCADE,
    FOREIGN KEY (ISBN) REFERENCES Books(ISBN) ON DELETE CASCADE
);
