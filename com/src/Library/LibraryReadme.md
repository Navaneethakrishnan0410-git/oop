# 📚 Library Management System (Java Console Application)

This is a simple Java-based Library Management System designed for console use. It allows users to manage books and members, issue and return books, and track penalties for late returns. It also logs all operations to a file for record-keeping.

---

## 🚀 Features

- Add new books and members
- Issue books to members
- Return books with late fee calculation
- View all books and their availability status
- View all members and their penalties
- Log all transactions to `library_log.txt`
- Custom exceptions for better error handling

---

## 🛠️ Technologies Used

- Java (JDK 8 or higher)
- File I/O for logging
- Exception handling
- Collections (HashMap)
- Console-based UI

---

## 📂 Project Structure
Library/ 
├── Book.java 
├── Member.java 
├── Library.java 
├── LibraryDemo.java 
└── Custom Exceptions (BookNotAvailableException, InvalidReturnException)

---

## 🧑‍💻 How to Run

1. **Clone or Download** this repository.
2. **Compile the code** using your terminal or IDE:
   ```bash
   javac com/Library/LibraryDemo.java


- 
=== Library Menu ===
1. Add Book
2. Add Member
3. Issue Book
4. Return Book
5. Show All Books
6. Show All Members (with Penalty)
0. Exit