package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.Genres;
import java.io.Serializable;
import java.util.List;

public interface AddGenreLogic extends Serializable{
    public String getNameGenre(int id);
    public List getAllGenres();
    public int getGenreId(String name);
    public void saveGenre(Genres genre);
}
