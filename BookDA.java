import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class BookDA{
    private HashMap<String, Author> authorMap;

    public BookDA(){
        readAuthors();
        readBooks();
    }

    private void readAuthors(){
        AuthorDA authorDA = new AuthorDA();
        authorMap = authorDA.getAuthorMap();
    }

    private void readBooks(){
        try{
            Scanner bookFile = new Scanner(new FileReader("/workspaces/HashMapLab/Book.csv"));
            bookFile.nextLine();

            while (bookFile.hasNext()){
                String bookData = bookFile.nextLine();
                String[] bookFileSpecific = bookData.split(",");

                Book book = new Book();
                book.setISBN(bookFileSpecific[0].trim());
                book.setTitle(bookFileSpecific[1].trim());  

                Author author = authorMap.get(bookFileSpecific[2].trim());
                book.setAuthor(author);

                printReport(book);
            }
            bookFile.close();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private void printReport(Book book){
        System.out.println("\n" + book.getISBN() + " " + book.getTitle());
             
        Author author = book.getAuthor();
        if (author != null){
            System.out.println("\t" + author.getName() + " - " + author.getBio());
        }
        else {
            System.out.println("Author information not available.");
        }

        System.out.println();
    }
}