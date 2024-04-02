import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class AuthorDA{
    private HashMap<String, Author> authorMap;

    public HashMap<String, Author> getAuthorMap(){
        return authorMap;
    }

    public AuthorDA(){
        authorMap = new HashMap<>();
        readAuthorFIle();
    }

    private void readAuthorFIle(){
        try {
            Scanner authorFile = new Scanner(new FileReader("/workspaces/HashMapLab/Author.csv"));
            authorFile.nextLine();
           
            while (authorFile.hasNext()){
                String authorData = authorFile.nextLine();
                String[] authorDataSpecific = authorData.split(",");

                if (authorDataSpecific.length >= 2) {
                    String name = authorDataSpecific[0].trim();
                    String bio = authorDataSpecific[1].trim();
            
                    Author author = new Author();
                    author.setName(name);
                    author.setBio(bio);
                
                    authorMap.put(name, author);
                }
            }

            authorFile.close();
        }

        catch (FileNotFoundException e){
            throw new RuntimeException(e);

        }
    }

}