package lms;

class User {
	Book[] borrowed = new Book[100];
	String[] names = new String[100];
	int count = 0;

	boolean borrowBook(Library lib, String personName, String title) {
		Book book = lib.findBook(title);

		if (book != null && book.borrowing()) {

			borrowed[count] = book;
			names[count] = personName;
			count++;

			System.out.println(personName + " borrowed the book: " + title);

			return true;
		}
		return false;
	}

	boolean returnBook(String personName, String title) {
		for (int i = 0; i < count; i++) {
			if (borrowed[i].title.equalsIgnoreCase(title) && names[i].equalsIgnoreCase(personName)) {

				borrowed[i].returning();

				System.out.println(personName + " returned the book: " + title);

				for (int j = i; j < count - 1; j++) {
					borrowed[j] = borrowed[j + 1];
					names[j] = names[j + 1];
				}

				borrowed[count - 1] = null;
				names[count - 1] = null;
				count--;

				return true;
			}
		}
		return false;
	}
}
