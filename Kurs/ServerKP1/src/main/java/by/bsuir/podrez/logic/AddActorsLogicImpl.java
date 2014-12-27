package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.ActorsDAO;
import by.bsuir.podrez.database.DAO.ActorsDAOImpl;
import by.bsuir.podrez.database.DAO.PerformancesDAO;
import by.bsuir.podrez.database.DAO.PerformancesDAOImpl;
import by.bsuir.podrez.database.model.Actors;
import by.bsuir.podrez.database.model.Performances;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddActorsLogicImpl implements AddActorsLogic{

    @Override
    public String getNamePerformance(int id) {
        PerformancesDAO sdao = new PerformancesDAOImpl();
        Performances performance = (Performances) sdao.read(id);
        Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  performance.getName();
    }

    @Override
    public List getAllPerformances() {
        PerformancesDAO sdao = new PerformancesDAOImpl();
        return sdao.getPerformanse();
    }

    @Override
    public synchronized void saveActor(Actors actor) {
        ActorsDAO bdao = new ActorsDAOImpl();
         if(actor.getId() == 0) {
             Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", actor.toString());
             bdao.create(actor);
         } else {
             Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о актере");
             bdao.update(actor);
         } 
    }

    @Override
    public int getPerformanceId(String name) {
        PerformancesDAO sdao = new PerformancesDAOImpl();
        Performances performance = (Performances) sdao.getPerformanceByName(name);
        Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "Отправка ID спектакля");
        return  performance.getId();
    }

    @Override
    public String getNameActor(int id) {
        ActorsDAO sdao = new ActorsDAOImpl();
        Actors actor = (Actors) sdao.read(id);
       Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  actor.getSurname();
    }      
}
