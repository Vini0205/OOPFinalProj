# Inventory Management System

## Overview
This Inventory Management System is a Java-based application that allows users to manage product information, including adding, viewing, updating, and deleting products. The application uses a MySQL database to store product data and provides a user-friendly graphical interface.

## Features
- User authentication for secure access
- Add new products to the inventory
- View existing products in a table format
- Update product details
- Delete products from the inventory
- Search for products by ID

## Prerequisites
Before running the application, ensure you have the following installed:
- Java Development Kit (JDK) 8 or higher
- MySQL Server
- MySQL Connector/J (JDBC Driver)

## Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Vini0205/OOPFinalProj

Set Up the Database

Create a new database in MySQL:
CREATE DATABASE awaw;

Set Up the Database

Create a new database in MySQL:
CREATE TABLE wawa (
    ID VARCHAR(50) PRIMARY KEY,
    `Product Name` VARCHAR(100),
    Price DECIMAL(10, 2),
    Quantity INT
);

Use Login
Usesrname = me 
Password = 123

Usage
Launch the application.
Enter your username and password to log in.
Use the main interface to manage products:
Add: Fill in the product details and click "Add".
View: Select a product ID from the dropdown to view its details.
Update: Modify the product details and click "Update".
Delete: Select a product ID and click "Delete" to remove it from the inventory.
Search: Use the search functionality to find products by ID.

Troubleshooting
If you encounter any issues, check the console for error messages.
Ensure that the MySQL server is running and that the database connection details are correct.
   
