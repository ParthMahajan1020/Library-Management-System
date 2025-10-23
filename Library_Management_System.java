import java.util.Scanner;
import java.util.ArrayList;

class Book {
    int bookID;
    String title;
    String author;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }

    public int getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void show_book_info() {
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("---------------------------------------");
    }
}

class User {
    int userID;
    String name;
    ArrayList<Book> borrowedBooks;   // Store list of books the user has borrowed

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book b) {
        borrowedBooks.add(b);
        System.out.println(name + " borrowed: " + b.title + ".");
    }

    public void returnBook(Book b) {
        if (borrowedBooks.remove(b)) {
            System.out.println(name + " returned: " + b.title + ".");
        } else {
            System.out.println(b.title + " was not borrowed by " + name + ".");
        }
    }

    public void show_borrowed_books() {
        System.out.println("Books borrowed by " + name + ":");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books Borrowed.");
        } else {
            for (Book b : borrowedBooks) {
                b.show_book_info();
            }
        }
    }
}

class Library {
    ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();  // Initial books

        books.add(new Book(101, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(102, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(103, "1984", "George Orwell"));
        books.add(new Book(104, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(105, "Moby Dick", "Herman Melville"));
        books.add(new Book(106, "War and Peace", "Leo Tolstoy"));
        books.add(new Book(107, "The Catcher in the Rye", "J.D. Salinger"));
        books.add(new Book(108, "The Hobbit", "J.R.R. Tolkien"));
        books.add(new Book(109, "Crime and Punishment", "Fyodor Dostoevsky"));
        books.add(new Book(110, "The Odyssey", "Homer"));
        books.add(new Book(111, "Brave New World", "Aldous Huxley"));
        books.add(new Book(112, "The Lord of the Rings", "J.R.R. Tolkien"));
        books.add(new Book(113, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling"));
        books.add(new Book(114, "Alice's Adventures in Wonderland", "Lewis Carroll"));
        books.add(new Book(115, "Jane Eyre", "Charlotte Brontë"));
        books.add(new Book(116, "Frankenstein", "Mary Shelley"));
        books.add(new Book(117, "The Alchemist", "Paulo Coelho"));
        books.add(new Book(118, "The Divine Comedy", "Dante Alighieri"));
        books.add(new Book(119, "Don Quixote", "Miguel de Cervantes"));
        books.add(new Book(120, "The Brothers Karamazov", "Fyodor Dostoevsky"));
    }

    // Show available books
    public void show_available_books() {
        System.out.println("Available Books: ");
        for (Book b : books) {
            b.show_book_info();
        }
    }

    // Add new books
    public void add_book(int bookID, String title, String author) {
        books.add(new Book(bookID, title, author));
        System.out.println("Book Added Successfully!");
    }

    // Lend a book to user
    public void lendBook(User user, int bookID) {
        for (Book b : books) {
            if (b.bookID == bookID) {
                user.borrowBook(b);
                books.remove(b);
                return;
            }
        }
        System.out.println("Book ID " + bookID + " not found.");
    }

    // Receive returned book from user
    public void receiveBook(User user, Book book) {
        user.returnBook(book);
        books.add(book);
    }
}

public class Library_Management_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        System.out.println("\n===== Welcome to Library =====");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your userID: ");
        int userID = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        User currentUser = new User(userID, name);
        System.out.println("--------------------------------\n");

        boolean running = true;
        while (running) {
            System.out.println("--- Menu ---");
            System.out.println("1. Add new Book to library");
            System.out.println("2. Borrow Book from library");
            System.out.println("3. Return Book to library");
            System.out.println("4. Show Available Books");
            System.out.println("5. Show My Borrowed Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.println("--------------------------------");

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Title of the Book: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    library.add_book(id, title, author);
                    break;

                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowID = sc.nextInt();
                    sc.nextLine();
                    library.lendBook(currentUser, borrowID);
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnID = sc.nextInt();
                    sc.nextLine();
                    Book bookToReturn = null;
                    for (Book b : currentUser.borrowedBooks) {
                        if (b.bookID == returnID) {
                            bookToReturn = b;
                            break;
                        }
                    }
                    if (bookToReturn != null) {
                        library.receiveBook(currentUser, bookToReturn);
                    } else {
                        System.out.println("You did not borrow this book.");
                    }
                    break;

                case 4:
                    library.show_available_books();
                    break;

                case 5:
                    currentUser.show_borrowed_books();
                    break;

                case 6:
                    System.out.println("Exiting Library System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }

            System.out.println("--------------------------------\n");
        }

        sc.close();
    }
}