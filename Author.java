import java.util.HashMap;

public class Author{
    private String name;
    private String bio;
    private HashMap<String, Author> authorMap;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBio(){
        return bio;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public HashMap<String, Author> getAuthorMap(){
        return authorMap;
    }

    public void setAuthorMap(HashMap<String, Author> authorMap) {
        this.authorMap = authorMap;
    }
}