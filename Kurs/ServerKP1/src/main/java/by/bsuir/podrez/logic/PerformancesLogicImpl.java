package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.PerformancesDAO;
import by.bsuir.podrez.database.DAO.PerformancesDAOImpl;
import by.bsuir.podrez.database.model.DataBaseObject;
import by.bsuir.podrez.database.model.Performances;
import java.util.List;

public class PerformancesLogicImpl implements PerformancesLogic{

    @Override
    public List getAllPerformances() {
        PerformancesDAO sdao = new PerformancesDAOImpl();
        return sdao.getPerformanse();
    }

    @Override
    public void deletePerformance(Performances performance) {
        PerformancesDAO bdao = new PerformancesDAOImpl();
        bdao.delete(performance.getId());
    }

    @Override
    public int searchPerformance(String str) {
        PerformancesDAO bdao = new PerformancesDAOImpl();
        return bdao.getId_performance(str);
    }

    @Override
    public List filterGenre(int id) {
        PerformancesDAO sdao = new PerformancesDAOImpl();
        return sdao.getPerformanceGenre(id);
    }
    
}
