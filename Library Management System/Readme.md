# Library Management System

Welcome to the **Library Management System**! This Java-based application is designed to streamline the management of library resources, including books, members, and loans. Built with a focus on Object-Oriented Programming (OOP) and the Singleton design pattern, the system is structured to be efficient, scalable, and easy to use.
---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Features](#features)
- [New Additions](#new-additions)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

The Library Management System (LMS) offers the essential functionalities for managing books, member data, and loan records within a library. The project emphasizes a modular structure and efficient data handling, making it a robust solution for small to medium-sized libraries.

---

## Tech Stack

This project utilizes the following technologies:

- **Java** - Primary programming language
- **MySQL** - Relational Database Management System
- **MySQL Workbench** - Database design and management tool
- **JDBC** - Java Database Connectivity for MySQL integration
- **IntelliJ IDEA** - Integrated Development Environment (IDE)
- **Object-Oriented Programming (OOP)** - Core project design methodology
- **Singleton Design Pattern** - Ensures a single instance of key components for data integrity

---

## Features

- **Book Management**
  - Add new books with unique ISBNs, update details, and manage stock.
  - Display total available copies of each book.
  - Increase or decrease stock based on borrowing or returns.

- **Member Management**
  - Register members with unique IDs.
  - Validate Egyptian phone numbers.
  - Track borrowed books, allowing a maximum of two unique books per member.

- **Loan Management**
  - Borrow and return books while tracking loan periods.
  - Status tracking for on-time and overdue returns.
  - Notify members when attempting to borrow books they've already checked out.

---

## New Additions

- **Extended Loan Management**
  - Added functionality to track overdue loans more accurately.
  - Status labels for active loans and overdue loans, enhancing member notifications.
  
- **Additional Database Support**
  - Enhanced database schema for improved performance and scalability.
  - Updated JDBC configurations to align with new database optimizations.

- **Additional Helper Classes**
  - Helper utilities to manage data validation and streamline error handling across the application.

---

## Project Structure

The project is organized into multiple classes for clear separation of responsibilities:

- `LibrarySystem` - Main entry point and manager for the overall system.
- `BookManager` - Handles adding, updating, and managing book inventory.
- `MemberManager` - Manages member records and enforces borrowing limits.
- `LoanManager` - Oversees loan operations, including borrowing, returns, and status tracking.
- **Helper Classes** - Utility classes for data validation and streamlined database operations.

Each class follows OOP principles and implements the Singleton pattern where appropriate for consistent data handling across the system.

---

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/DevBassam/Java-OOP-Projects.git
   cd "Library Management System"
   ```

2. **Configure Database**
   - Create a MySQL database named `library_db`.
   - Execute the SQL script to set up tables and relationships.
   - Update JDBC connection details in the code to match your setup.

3. **Run the Project**
   - Open the project in IntelliJ IDEA.
   - Compile and run the main class to start the application.

---

## Usage

Use the command-line interface to interact with the system. Follow prompts for book management, member registration, loan operations, and more.

---
Feel free to explore the [issues page](https://github.com/DevBassam/Java-OOP-Projects/issues) for open requests or suggestions.

---
