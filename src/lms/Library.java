package lms;

class Library {
	Book[] store = new Book[100];
	int count = 0;

	boolean addBook(Book book) {
		if (count >= store.length)
			return false;
		store[count++] = book;
		return true;
	}

	Book findBook(String title) {
		for (int i = 0; i < count; i++) {
			if (store[i].title.equalsIgnoreCase(title)) {
				return store[i];
			}
		}
		return null;
	}

	void showAll() {
		if (count == 0) {
			System.out.println("No books available.");
			return;
		}
		for (int i = 0; i < count; i++) {
			store[i].displayDetails();
			System.out.println("--------------------");
		}
	}
}
