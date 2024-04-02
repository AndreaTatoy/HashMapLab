import java.util.HashMap;

public class Book{
    private String isbn;
    private String title;
    private Author author;
    private HashMap<String, Book> bookMap;
    private HashMap<String, Author> authorMap;
    
    public Author getAuthor(){
        return author;
    }

    public void setAuthor(Author author){
        this.author = author;
    }
    
    public String getISBN(){
        return isbn;
    }

    public void setISBN(String isbn){
        this.isbn = isbn;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public HashMap<String, Book> getBookMap(){
        return bookMap;
    }

    public void setBookMap(HashMap<String, Book> bookMap){
        this.bookMap = bookMap;
    }

    public HashMap<String, Author> getAuthorMap(){
        return authorMap;
    }

    public void setAuthorMap(HashMap<String, Author> authorMap){
        this.authorMap = authorMap;
    }
}
