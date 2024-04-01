import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookDA{
    private HashMap<String, Author> authorMap;

    public BookDA(){
        try{
            Scanner bookFile = new Scanner(new FileReader("/workspaces/HashMapLab/Book.csv"));

            bookFile.nextLine();

            while (bookFile.hasNext()){
                
                authorMap = new HashMap<>();
                String bookData = new String();
                bookData = bookFile.nextLine();

                String[] bookFileSpecific = new String[3];
                bookFileSpecific = bookData.split(",");

                Book book = new Book();
                book.setISBN(bookFileSpecific[0].trim());
                book.setTitle(bookFileSpecific[1].trim());  

                printReport(book);

            }

            bookFile.close();
        }

        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private void printReport(Book book){
        System.out.println("\n\nISBN: " + book.getISBN() +
                            "\n\nTitle: " + book.getTitle() + "\n");
                            
        for (Map.Entry<String, Author> entryMap: book.getAuthorMap().entrySet()){
            System.out.println(entryMap.getValue().getName());
            System.out.println(entryMap.getValue().getBio());
        }

        System.out.println();
    }

    private void readAuthor (Author author){
        AuthorDA authorDA = new AuthorDA(author.getName());
        author.setAuthorMap(authorDA.getAuthorMap());
    }

































    /*
    public BookDA(String isbn){
        try {
            Scanner bookFile = new Scanner(new FileReader("/workspaces/HashMapLab/BookDA.java"));
        
            bookMap = new HashMap<>();

            bookFile.nextLine();

            Integer key = 0;
            while (bookFile.hasNext()){
                String booksData = new String();
                booksData = bookFile.nextLine();

                String[] booksDataSpecific = new String[2];
                booksDataSpecific = booksData.split(",");

                if (isbn.equals(booksDataSpecific[0].trim())){
                    Book book = new Book();
                    book.setTitle(booksDataSpecific[1].trim());

                    bookMap.put(isbn+key, readBookFile(book));
                    key++;
                }
            }
        
        } 
        catch (FileNotFoundException e){
            throw new RunTimeException(e);
        }

    }

    private Book readBookFile (Book book) throws FileNotFoundException{
        Scanner 
    }

    */

}