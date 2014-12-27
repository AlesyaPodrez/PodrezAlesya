package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.Actors;
import java.io.Serializable;
import java.util.List;

public interface AddActorsLogic extends Serializable{
    
    public String getNamePerformance(int id);
    
    public String getNameActor(int id);
    
     public List getAllPerformances();
     
     public void saveActor(Actors actor);
     
     public int getPerformanceId(String name);
}
