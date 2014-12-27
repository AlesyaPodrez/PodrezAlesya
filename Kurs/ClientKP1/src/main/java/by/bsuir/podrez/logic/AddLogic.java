package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.Performances;
import java.io.Serializable;
import java.util.List;


public interface AddLogic extends Serializable{
    public String getNamePerformance(int id);
    public void savePerformance(Performances performance);
    public List getAllGenre();
    public String getNameGenre(int id);
    public int getGenreId(String name);
}
