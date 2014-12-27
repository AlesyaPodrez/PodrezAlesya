package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.model.DataBaseObject;
import java.util.List;

public interface TimetableSettingsDAO extends DAO{
    public List getTimetable();
    public List getTimetablePerformance(int id);
    public List getTimetableActor(int id);
}
