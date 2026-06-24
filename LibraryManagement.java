import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {

    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    addBook(sc);
                    break;

                case 2:
                    removeBook(sc);
                    break;

                case 3:
                    searchBook(sc);
                    break;

                case 4:
                    displayBooks();
                    break;

                case 5:
                    System.out.println("Thank you for using Library Management System!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
    static void addBook(Scanner sc) {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) {
            if (b.id == id) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book Added Successfully!");
    }

    static void removeBook(Scanner sc) {

        System.out.print("Enter Book ID to Remove: ");
        int id = sc.nextInt();

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).id == id) {

                books.remove(i);

                System.out.println("Book Removed Successfully!");
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    static void searchBook(Scanner sc) {

        System.out.print("Enter Book ID to Search: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id) {

                System.out.println("\nBook Found!");
                System.out.println("Book ID : " + b.id);
                System.out.println("Title   : " + b.title);
                System.out.println("Author  : " + b.author);

                return;
            }
        }

        System.out.println("Book Not Found!");
    }
               
    static void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available!");
            return;
        }

        System.out.println("\n===== BOOK LIST =====");

        for (Book b : books) {

            System.out.println("Book ID : " + b.id);
            System.out.println("Title   : " + b.title);
            System.out.println("Author  : " + b.author);
            System.out.println("----------------------");
        }
    }
}