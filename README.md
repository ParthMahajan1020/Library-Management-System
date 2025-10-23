# Library Management System

## Overview
This is a simple **Library Management System** built in Java. It allows users to manage books in a library, borrow and return them, and track borrowed books. The project uses **Object-Oriented Programming (OOP)** principles with classes like `Book`, `User`, and `Library`.

---

## Features

- Add new books to the library
- Borrow books from the library
- Return borrowed books to the library
- Show all available books in the library
- Show books borrowed by the user
- Simple menu-driven Command-Line Interface (CLI)

---

## Classes

### **Book**
Represents a book in the library.

**Attributes:**
- `bookID` – Unique ID for the book
- `title` – Book title
- `author` – Author name

**Methods:**
- `show_book_info()` – Displays book details

---

### **User**
Represents a library user.

**Attributes:**
- `userID` – Unique ID for the user
- `name` – User name
- `borrowedBooks` – List of books borrowed by the user

**Methods:**
- `borrowBook(Book b)` – Adds a book to borrowed list
- `returnBook(Book b)` – Removes a book from borrowed list
- `show_borrowed_books()` – Displays all borrowed books

---

### **Library**
Represents the library system.

**Attributes:**
- `books` – List of all available books

**Methods:**
- `add_book(int bookID, String title, String author)` – Adds a new book to the library
- `show_available_books()` – Displays all available books
- `lendBook(User user, int bookID)` – Lends a book to a user
- `receiveBook(User user, Book book)` – Receives a returned book from a user

---

## How to Use

1. **Compile the program**  
```bash
javac Library_Management_System.java
```
2. **Run the peogram**
```bash
java Library_Management_System
```

### **Sample Output**
```bash
===== Welcome to Library =====
Enter your name: Parth
Enter your userID: 101
--------------------------------

--- Menu ---
1. Add new Book to library
2. Borrow Book from library
3. Return Book to library
4. Show Available Books
5. Show My Borrowed Books
6. Exit
Enter your choice: 4
--------------------------------
Available Books:
Book ID: 101
Title: Pride and Prejudice
Author: Jane Austen
---------------------------------------
Book ID: 102
Title: To Kill a Mockingbird
Author: Harper Lee
---------------------------------------
... (other books listed)
--------------------------------

Enter your choice: 2
Enter Book ID to borrow: 103
Parth borrowed: 1984.
--------------------------------

Enter your choice: 5
Books borrowed by Parth:
Book ID: 103
Title: 1984
Author: George Orwell
--------------------------------
```

### **Future Enhancement**

- Multiple user support – Allow multiple users to borrow/return simultaneously

- Persistent storage – Use file or database to save books and borrowed history

- Duplicate book check – Prevent adding books with existing bookID

- Improved error handling – Handle invalid inputs gracefully

- Search functionality – Search books by title, author, or ID

- Graphical User Interface (GUI) – Upgrade from CLI to GUI for better usability

- Book categories – Organize books by genre, author, or year

- Book availability status – Show whether a book is currently borrowed or available

- Overdue tracking & notifications – Alert users if borrowed books are overdue

## Author

*Parth Mahajan*  
- BTech Student | Java & Software Development Enthusiast  
- GitHub: https://github.com/ParthMahajan1020  
- Email: parth.mahajan1020@example.com  
- Passionate about building console applications, learning new programming languages, and exploring software projects.
