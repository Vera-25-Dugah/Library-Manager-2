public class Book {

    //PRIVATE FIELDS TO ENSURE ENCAPSULATION
    private String title;
    private String author;
    private int    year;

    //CONSTRUCTOR FOR INITIALIZING FIELDS
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    //GETTERS
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int    getYear()   {
        return year;
    }

    //OVERRIDING TO-STRING METHOD
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + year + ")";
    }

    //TO FILE-STRING METHOD(converts a book to a one line text for file saving.)
    public String toFileString() {

        return title + "|" + author + "|" + year;
    }

    //STATIC METHOD FOR BOOK-(creates a string and stores the line text from file string then splits them to reconstruct and create a book object without having to do Book b = new Book();)
    public static Book fromFileString(String line) {
        String[] parts = line.split("\\|");
        String  title  = parts[0];
        String  author = parts[1];
        int     year   = Integer.parseInt(parts[2]);
        return new Book(title, author, year);
    }








    }
