import java.util.Scanner;

public class Test {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        LibraryManager manager = new LibraryManager();
        System.out.println( "LIBRARY MANAGER");

        boolean running = true;
        while (running){
            showMenu();
            String choice = getInput(" Choose a number 1 - 5 to select a function");

            switch(choice){
                case "1":
                    String title = getInput(" Title: ");
                    String author = getInput("  Author: ");

                    int year = 0;
                    try {
                        year = Integer.parseInt(getInput(" Year: "));
                    }
                    catch(NumberFormatException e){
                        System.out.println("Please enter a number from 1 - 5 : ");
                        break;
                    }

                    manager.addBook(title,author,year);
                    break;

                case "2":
                    manager.viewAllBooks();
                    break;

                case "3":
                    String query = getInput("Search title: ");
                    manager.searchBook(query);
                    break;

                case "4":
                    String delTitle = getInput("  Title to delete: ");
                    manager.deleteBook(delTitle);
                    break;

                case "5":
                    System.out.println("\n  Goodbye! Books saved.\n");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1 to 5:  ");

            }
        }

        scanner.close();
        }

        //SHOW MENU METHOD
        private static void showMenu() {
            System.out.println("\n  MENU TO SELECT FUNCTION");
            System.out.println("  1. Add a book");
            System.out.println("  2. View all books");
            System.out.println("  3. Search for a book");
            System.out.println("  4. Delete a book");
            System.out.println("  5. Exit");
        }

        //GET INPUT METHOD
        private static String getInput(String prompt) {
            System.out.print(prompt);
            return scanner.nextLine().trim();
        }

    }


