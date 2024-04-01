import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class AuthorDA{
    private HashMap<String, Author> authorMap;

    public HashMap<String, Author> getAuthorMap(){
        return authorMap;
    }

    public AuthorDA(String name){
        try {
            Scanner authorFile = new Scanner(new FileReader("/workspaces/HashMapLab/Author.csv"));

            authorMap = new HashMap<>();

            authorFile.nextLine();

            Integer key = 0;
            while (authorFile.hasNext()){
                String authorData = new String();
                authorData = authorFile.nextLine();

                String[] authorDataSpecific = new String[2];
                authorDataSpecific = authorData.split(",");

                if (name.equals(authorDataSpecific[0].trim())){
                    Author author = new Author();
                    author.setBio(authorDataSpecific[1].trim());
                
                authorMap.put(name+key, readAuthorFile(author));
                    key++;
                }
            }
        }

        catch (FileNotFoundException e){
            throw new RuntimeException(e);

        }
    }

    private Author readAuthorFile(Author author) throws FileNotFoundException{
        Scanner authorFile = new Scanner(new FileReader("/workspaces/HashMapLab/Author.csv"));

        authorFile.nextLine();

        while (authorFile.hasNext()){
            String authorData = new String();
            authorData = authorFile.nextLine();

            String[] authorDataSpecific = new String[2];
            authorDataSpecific = authorData.split(",");

            if (author.getName().equals(authorDataSpecific[0].trim())){
                author.setBio(authorDataSpecific[1].trim());
                break;
            }
        }
        return author;
    }
}