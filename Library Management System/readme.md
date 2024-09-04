# Library Management System

Welcome to the Library Management System project. This project is designed to manage books and members in a library. It supports adding, updating, and removing books and members, as well as borrowing and returning books.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Techniques Used](#techniques-used)
- [Project Flow](#project-flow)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The Library Management System is a Java-based application that provides a set of functionalities for managing a library's book collection and its members. The application allows users to add, update, and remove books and members, as well as track book loans and returns.

## Features

- Add, update, and remove books from the catalog.
- Add, update, and remove members.
- Borrow and return books with constraints on the number of books a member can borrow.
- Increase the number of copies of a book if it already exists in the catalog.
- Display available books with the number of copies in stock.
- Ensure members cannot borrow more than two different books at a time.
- Validate data inputs such as ISBN, dates, member IDs, and phone numbers.

## Techniques Used

This project uses the following techniques:

- **Object-Oriented Programming (OOP)**: Classes like `Book`, `Member`, and `Library` are used to model real-world entities and their interactions.
- **Exception Handling**: Custom error messages and validation checks are implemented to handle invalid inputs and exceptional cases.
- **Data Validation**: Validations for ISBN, dates, member IDs, and phone numbers ensure correct data entry.
- **Collections Framework**: `HashMap` and `HashSet` are used for storing and managing books and members efficiently.
- **Command-Line Interface (CLI)**: The application interacts with users via a CLI, allowing them to perform various operations.

## Project Flow

The flow of the project is as follows:

1. **Initialization**: The application initializes the library with an empty catalog and member directory.
2. **User Interaction**: Users interact with the CLI to choose operations such as adding a book, removing a member, or borrowing a book.
3. **Data Handling**: Based on the user’s choice, the application performs the required operation, such as updating the book catalog or member records.
4. **Validation**: User inputs are validated to ensure correctness before processing.
5. **Feedback**: The system provides feedback to the user, such as success or error messages, based on the outcome of the operation.

## Usage

To use this application:

1. Run the `Main` class.
2. Follow the prompts to perform actions such as adding books or members, borrowing or returning books, etc.
3. Refer to the CLI options to choose different functionalities and perform operations as needed.


