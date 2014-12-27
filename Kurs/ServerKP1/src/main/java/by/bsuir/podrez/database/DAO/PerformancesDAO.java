package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.model.DataBaseObject;
import java.util.List;

public interface PerformancesDAO extends DAO{
    public List getPerformanse();
    public DataBaseObject getPerformanceByName( String name);
    public int getId_performance(String str);
    public List getPerformanceGenre(int id);
}
