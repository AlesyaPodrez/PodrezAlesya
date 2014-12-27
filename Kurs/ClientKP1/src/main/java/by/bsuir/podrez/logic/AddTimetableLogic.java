package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.TimetableSettings;
import java.io.Serializable;
import java.util.List;

public interface AddTimetableLogic extends Serializable{
    
     public List getAllPerformances();
     
     public List getAllActors();
     
     public String getNamePerformance(int id);
     
     public String getNameActor(int id);
     
     public int getPerformanceId(String name);
      public int getActorId(String name);
     
      public void saveTimetable(TimetableSettings timetable);
}
