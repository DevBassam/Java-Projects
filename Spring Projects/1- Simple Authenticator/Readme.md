# User Registration and Login System

This project implements a simple user registration and login system using Spring MVC. The system allows users to sign up, log in, and view registered users. It validates input data during signup and login processes and ensures security measures such as password strength checks.

## Features

- **User Signup:**
  - Users can sign up with a valid Gmail address, a strong password, first name, and last name.
  - The system validates the data to ensure that the fields are correct and meet the specified requirements.
  - Users are prevented from signing up with an email that already exists in the system.

- **User Login:**
  - Users can log in using their email and password.
  - If the email or password is incorrect, an error message is displayed.

- **User Data Display:**
  - After logging in, users are directed to a page displaying a list of all registered users with their email, first name, and last name.

- **Error Handling:**
  - Detailed error messages are provided for cases such as incorrect login credentials or invalid data during signup.

## Technologies Used

- **Spring MVC** for handling web requests and rendering views.
- **JSP** for the view layer.
- **Spring Form Tags** for binding form data.
- **CSS** for styling the application.
- **Java Validation** for validating user input during signup and login.

## Directory Structure
![image](https://github.com/user-attachments/assets/340fb1dd-b0d3-4ac9-b438-817ead129bea)


## Setup

### Prerequisites

- Java 17 or above
- Maven (for dependency management)
- Spring Framework
- An IDE (e.g., IntelliJ IDEA or Eclipse)
- Tomcat or any servlet container

### How to Run

1. Clone the repository.
2. Open the project in your IDE.
3. Build the project using Maven.
4. Run the application on a servlet container (Tomcat 10.1.33).
5. Navigate to `http://localhost:8080/` in your browser.

### Usage

1. **Sign Up:** Navigate to the signup page and fill in the required fields.
2. **Login:** After signing up, you can log in with the created email and password.
3. **View Registered Users:** After logging in, you will be redirected to a page showing all registered users.

## Styling

The styles are implemented in the CSS files located in the `/resources/css/` directory. Each JSP page includes its specific CSS file to apply the desired look and feel to the forms and data display.

## Acknowledgments

All JSP and CSS files in this project were created with the assistance of AI "Claude sonnet 3.5."
