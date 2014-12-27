package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.TimetableSettingsDAO;
import by.bsuir.podrez.database.DAO.TimetableSettingsDAOImpl;
import by.bsuir.podrez.database.model.DataBaseObject;
import by.bsuir.podrez.database.model.TimetableSettings;
import java.util.List;

public class TimetableLogicImpl implements TimetableLogic{

    @Override
    public List getAllTimetable() {
        TimetableSettingsDAO sdao = new TimetableSettingsDAOImpl();
        return sdao.getTimetable();
    }

    @Override
    public void deleteTimetable(TimetableSettings timetable) {
        TimetableSettingsDAO bdao = new TimetableSettingsDAOImpl();
        bdao.delete(timetable.getId());
    }

    @Override
    public List filterPerformance(int id) {
        TimetableSettingsDAO sdao = new TimetableSettingsDAOImpl();
        return sdao.getTimetablePerformance(id);
    }

    @Override
    public List filterActor(int id) {
        TimetableSettingsDAO sdao = new TimetableSettingsDAOImpl();
        return sdao.getTimetableActor(id);
    }
    
}
