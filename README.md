This project is a web-based banking system developed using Advanced Java (JSP + Servlets) and manual JDBC for database connectivity.
It enables users to manage their banking operations securely via an interactive user interface and database integration through SQL queries.
The application uses a traditional web.xml file for servlet mapping and deployment configuration.

The project is divided into two main modules:
 1. User Authentication Module
 2. Account Management Module

🧑‍💼 Module 1: User Authentication (Security Layer)
This module handles user identity and access management, ensuring only verified users can access the banking features.

🔹 Features:
User Registration: Allows new users to sign up by storing details in a MySQL database.

Login Validation: Authenticates users using username and password with JDBC PreparedStatement.

Forgot Password: Users can retrieve their forgotten password using security questions.

Update Password: Users can update their existing password securely.

Delete Account: Users can delete their login account permanently.

All the above features use manual JDBC code (e.g., Connection, PreparedStatement, ResultSet) for CRUD operations
and are configured through the web.xml deployment descriptor for servlet mapping.

🏦 Module 2: Account Management
Accessible only after successful login. This module provides core banking services.

🔹 Features:
Open Account: Create a new bank account with a type (e.g., Savings, Current) and initial deposit.

Deposit Amount: Add funds to an account and update the database record.

Withdraw Amount: Withdraw funds with real-time balance checking.

Balance Enquiry: Retrieve and display the current account balance from the database.

Delete Bank Account: Permanently remove the user’s bank account.

All operations are implemented using JDBC for database communication, with Servlets as the controller layer and JSP/HTML for frontend forms.

