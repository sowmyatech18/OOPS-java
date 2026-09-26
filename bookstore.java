class Book {

    private String title;
    private String author;
    private double price;

 
    public Book() {
        title = "Not Available";
        author = "Not Available";
        price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setDetails(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}


public class bookstore {

    public static void main(String[] args) {

        Book book1 = new Book();
        System.out.println("Book Info (Default Constructor):");
        book1.displayDetails();
        System.out.println();

        Book book2 = new Book("Harry Potter", "J.K. Rowling", 650.0);
        System.out.println("Book Info (Parameterized Constructor):");
        book2.displayDetails();
        System.out.println();

        book1.setDetails("It Ends With Us", "Colleen Hoover", 700.0);
        System.out.println("Updated Book Info:");
        book1.displayDetails();
        
    }
}

