package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.Genres;
import java.io.Serializable;
import java.util.List;

public interface GenresLogic extends Serializable{
    public List getAllGenres();
 
    public void deleteGenre(Genres genre);
    public int searchGenre(String str);
    public String searchAge(String str);
    public List filterGenre(String age);
}
