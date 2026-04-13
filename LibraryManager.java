import java.util.ArrayList;
import java.io.IOException;

public class LibraryManager {
    private ArrayList<Book> books;
    private FileHandler fileHandler;

    //CONSTRUCTOR
    public LibraryManager() {
        fileHandler = new FileHandler();
        try {
            books = fileHandler.loadBooks(); // load saved data on startup
        } catch (IOException e) {
            // If loading fails, start with an empty list instead of crashing
            System.out.println("Could not load saved books. Starting fresh.");
            books = new ArrayList<>();
        }
    }

    //ADD BOOK METHOD
    public void addBook(String title, String author, int year) {

        // Guard: don't add a book with an empty title
        if (title.trim().isEmpty() || author.trim().isEmpty()) {
            System.out.println(" Title and author cannot be empty.");
            return;
        }

        Book newBook = new Book(title, author, year); // create Book object
        books.add(newBook);                           // add to in-memory list
        saveWithFeedback();                           // persist to file
        System.out.println("New Book Added: " + newBook);
    }

    //VIEW BOOKS METHOD
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        System.out.println("Library of Books Available");
        int i = 1;
        for (Book book : books) {
            System.out.println(" " + i + ". " + book);
            i++;
        }
        System.out.println(".................");
    }

    //SEARCH BOOK METHOD
    public void searchBook(String query) {
        String lowerQuery = query.toLowerCase();
        boolean found = false;

        System.out.println("\n SEARCH RESULTS");

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(lowerQuery)) {
                System.out.println(" Searching " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println(" Book not found" + query + " ");
        }
        System.out.println("...................");
    }

    //DELETE METHOD

    public void deleteBook(String title) {
        String lower = title.toLowerCase();
        boolean removed = books.removeIf(
                book -> book.getTitle().toLowerCase().equals(lower)
        );

        if (removed) {
            saveWithFeedback();
            System.out.println(" Title deleted :  " + title);
        } else {
            System.out.println("No book found with title : " + title);
        }
    }


    //HELPER METHOD
    private void saveWithFeedback() {
        try {
            fileHandler.saveBooks(books);
        } catch (IOException e) {
            System.out.println("Could not save to file" + e.getMessage());
        }
    }
}