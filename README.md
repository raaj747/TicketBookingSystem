# 🚆 Ticket Booking System

A simple **Java-based Ticket Booking System** developed as a console application. The project allows users to manage trains, book tickets, cancel tickets, and view booking information.

## 📌 Features

* Add new trains
* View all available trains
* Book tickets for passengers
* Automatically generate Train IDs and Ticket IDs
* Check available seats before booking
* Cancel booked tickets
* Restore seats after ticket cancellation
* View all current bookings
* Simple menu-driven console interface

## 🛠️ Technologies Used

* **Java**
* **Maven**
* **Object-Oriented Programming (OOP)**
* **Git & GitHub**
* **IntelliJ IDEA**

## 🧱 Project Structure

```text
TicketBookingSystem
│
├── src
│   └── main
│       └── java
│           └── org
│               └── example
│                   └── TBS.java
│
├── pom.xml
├── .gitignore
└── README.md
```

## 💡 OOP Concepts Used

This project demonstrates several fundamental Java OOP concepts:

* **Classes and Objects** – `Train`, `Ticket`, and `TBS`
* **Constructors** – Used to initialize train and ticket objects
* **Encapsulation** – Data and related behavior are organized inside classes
* **Object Relationships** – A `Ticket` contains a `Train` object
* **Static Variables** – Used for automatic ID generation

## 🎫 System Workflow

### 1. Add Train

The user enters:

* Train name
* Source
* Destination
* Total number of seats

The system automatically generates a unique Train ID.

### 2. Book Ticket

The user provides:

* Train ID
* Passenger name
* Number of seats

The system checks the available seats and creates a ticket if enough seats are available.

### 3. Cancel Ticket

The user enters the Ticket ID. The system cancels the ticket and returns the booked seats to the train.

### 4. View Bookings

The system displays information about all currently booked tickets.

## 🆔 ID System

Train IDs start from:

```text
1, 2, 3, 4...
```

Ticket IDs start from:

```text
1001, 1002, 1003...
```

Using different ranges makes Train IDs and Ticket IDs easy to distinguish.

## 📊 Data Storage

The current version uses Java arrays for storing data:

```java
Train[] trains = new Train[5];
Ticket[] tickets = new Ticket[20];
```

Therefore, the system can store up to:

* **5 trains**
* **20 tickets**

## ▶️ How to Run

### Clone the repository

```bash
git clone https://github.com/raaj747/TicketBookingSystem.git
```

### Open the project

Open the project using **IntelliJ IDEA** or another Java IDE.

### Run the application

Run:

```text
TBS.java
```

The application will display a menu in the console.

## 🔮 Future Improvements

Some possible improvements for future versi
