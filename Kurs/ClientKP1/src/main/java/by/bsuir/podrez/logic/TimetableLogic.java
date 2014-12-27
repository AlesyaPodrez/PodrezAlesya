package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.DataBaseObject;
import by.bsuir.podrez.database.model.TimetableSettings;
import java.io.Serializable;
import java.util.List;

public interface TimetableLogic extends Serializable{
    public List getAllTimetable();
 
    public void deleteTimetable(TimetableSettings timetable);
    public List filterPerformance(int id);
    public List filterActor(int id);
}
