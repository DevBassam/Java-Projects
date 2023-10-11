# Contacts Note Project

This project is a simple command-line application called "Contacts Note" that allows users to manage their contacts.
It provides basic functionality to add, update, delete, and display contacts.
The project consists of three Java classes: 'Contact', 'Note', and 'Main'.

## Contact Class
The 'Contact' class represents a single contact and has the following attributes:
- 'name': The name of the contact.
- 'phoneNumber': The phone number of the contact.
- 'email': The email address of the contact.
- 'address': The address of the contact.

The class provides getter and setter methods for each attribute.

## Note Class
The 'Note' class is responsible for managing all operations related to the contacts.
It uses a 'HashMap' to store the contacts' data, with the contact ID serving as the key. The class provides the following methods:

- 'openNote()': This method is the entry point for the application and manages all the operations.
     It displays a greeting message and prompts the user to choose an operation.
     Based on the user's choice, it performs actions such as adding a contact, updating a contact, deleting a contact, showing a contact by ID,
     and displaying all contacts.

- Basic Operation Methods:
  - 'addContact()': Prompts the user to enter contact details and adds the contact to the 'contacts' map.
  - 'deleteContact(int id)': Deletes a contact with the given ID from the 'contacts' map.
  - 'updateContact(int id)': Updates a contact with the given ID. It allows the user to choose which attribute(s) to update.
  - 'showContacts()': Displays all the contacts stored in the 'contacts' map.
  - 'showContactById(int id)': Displays the details of a contact with the given ID.

- Helpful Methods:
  - Various helper methods are used to obtain user input for contact details and operation choices.

## Main Class
The 'Main' class contains the 'main' method, which creates an instance of the 'Note' class and calls its 'openNote()' method to start the application.

## Features
The "Contacts Note" project offers the following features:
- Add a new contact by providing the name, phone number, email, and address.
- Update an existing contact by choosing which attribute(s) to modify.
- Delete a contact by specifying its ID.
- Show a contact's details by entering its ID.
- Display all contacts stored in the application.

## Skills Utilized
The implementation of the "Contacts Note" project demonstrates proficiency in the following skills:
- Object-oriented programming in Java.
- Handling user input and validation.
- Using collections (specifically 'HashMap') to store and manage data.
- Implementing basic CRUD operations (Create, Read, Update, Delete) for contact management.
- Command-line interface (CLI) application development.

Please note that this is a brief description of the project. For detailed usage instructions and additional information,
please refer to the project's source code itself.
