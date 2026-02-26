package lms;

class Book {
    String title;
    String author;
    int copiesAvailable;

    boolean borrowing() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
            return true;
        }
        return false;
    }

    void returning() {
        copiesAvailable++;
    }

    void displayDetails() {
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Copies  : " + copiesAvailable);
    }
}
