package lms;

import java.util.Scanner;

public class Library_Management_System {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Library library = new Library();
		User user = new User();

		while (true) {
			System.out.println("\n=== Library Management System ===");
			System.out.println("1. Add Book");
			System.out.println("2. Display All Books");
			System.out.println("3. Search Book by title");
			System.out.println("4. Borrow Book");
			System.out.println("5. Return Book");
			System.out.println("6. Exit");
			System.out.print("Enter your Choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print(" Enter book Type (1.Fiction 2.Non-Fiction): ");
				int type = sc.nextInt();
				sc.nextLine();

				System.out.print(" Enter book Title: ");
				String title = sc.nextLine();

				System.out.print("Enter book Author: ");
				String author = sc.nextLine();

				System.out.print("Enter no.of Copies: ");
				int copies = sc.nextInt();
				sc.nextLine();

				Book book;

				if (type == 1) {
					FictionBook fb = new FictionBook();
					System.out.print("Enter Genre: ");
					fb.genre = sc.nextLine();
					book = fb;
				} else {
					NonFictionBook nfb = new NonFictionBook();
					System.out.print("Enter Subject: ");
					nfb.subject = sc.nextLine();
					book = nfb;
				}

				book.title = title;
				book.author = author;
				book.copiesAvailable = copies;

				if (library.addBook(book))
					System.out.println("Book added to the library.");
				else
					System.out.println("Library is full.");
				break;

			case 2:
				library.showAll();
				break;

			case 3:
				System.out.print("Enter title: ");
				title = sc.nextLine();
				Book found = library.findBook(title);
				if (found != null)
					found.displayDetails();
				else
					System.out.println("Book not found.");
				break;

			case 4:
				System.out.print("Your name: ");
				String name = sc.nextLine();

				System.out.print("Book title: ");
				String borrowTitle = sc.nextLine();

				if (!user.borrowBook(library, name, borrowTitle))
					System.out.println("Book not available.");
				break;

			case 5:
				System.out.print("Your name to Return: ");
				String rName = sc.nextLine();

				System.out.print("Book title: ");
				String rTitle = sc.nextLine();

				if (!user.returnBook(rName, rTitle))
					System.out.println("No matching record.");
				break;

			case 6:
				System.out.println("Bye.........");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
