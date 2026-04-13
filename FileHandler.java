import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class FileHandler {

    private static final String FILE_PATH = "books.txt";

    //METHODS OF FILE-HANDLER(saves,load books)

    public void saveBooks(List<Book> books) throws IOException {
        //ERROR HANDLING TAKES EFFECT ALWAYS.
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_PATH, false))) {

            // Loop through every Book in the list
            for (Book book : books) {
                writer.write(book.toFileString()); // write "Title|Author|Year"
                writer.newLine();                  // write a line break after each
            }
        }
    }
        // The writer is automatically closed here by try-with-resources

        public ArrayList<Book> loadBooks() throws IOException {

            ArrayList<Book> books = new ArrayList<>();

            // CHECKING F FILE EXISTS BEFORE OPENING IF NOT RETURNS AN EMPTY LIST
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return books; // return empty list
            }

            try (BufferedReader reader = new BufferedReader(
                    new FileReader(FILE_PATH))) {

                String line;

                // readLine() returns null when end of file is reached.
                // This loop reads every line until EOF.
                while ((line = reader.readLine()) != null) {

                    if (!line.trim().isEmpty()) {
                        books.add(Book.fromFileString(line)); // rebuild Book from text
                    }
                }
            }

            return books;
        }

    }
