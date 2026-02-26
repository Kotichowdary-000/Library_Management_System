package lms;

class NonFictionBook extends Book {
    String subject;

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Subject : " + subject);
    }
}