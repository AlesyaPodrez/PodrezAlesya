package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.model.DataBaseObject;
import java.util.List;

public interface GenreDAO extends DAO{
     public List getGenre();
    public DataBaseObject getGenreByName( String name);
     public int getId_genre(String str);
     public String getId_age(String str);
     public List getGenreAge(String age);
}
