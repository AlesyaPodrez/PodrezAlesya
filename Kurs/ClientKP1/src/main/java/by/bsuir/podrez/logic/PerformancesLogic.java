package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.DataBaseObject;
import by.bsuir.podrez.database.model.Performances;
import by.bsuir.podrez.database.model.TimetableSettings;
import java.io.Serializable;
import java.util.List;


public interface PerformancesLogic extends Serializable{
    
    public List getAllPerformances();
 
    public void deletePerformance(Performances performance);
    public int searchPerformance(String str);
    public List filterGenre(int id);
}
