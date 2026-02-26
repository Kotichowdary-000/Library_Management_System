package lms;

class FictionBook extends Book {
    String genre;

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Genre   : " + genre);
    }
}
