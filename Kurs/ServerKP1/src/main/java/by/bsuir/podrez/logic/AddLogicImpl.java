package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.GenreDAO;
import by.bsuir.podrez.database.DAO.GenreDAOImpl;
import by.bsuir.podrez.database.DAO.PerformancesDAO;
import by.bsuir.podrez.database.DAO.PerformancesDAOImpl;
import by.bsuir.podrez.database.model.Genres;
import by.bsuir.podrez.database.model.Performances;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddLogicImpl implements AddLogic{

    @Override
    public String getNamePerformance(int id) {
        PerformancesDAO sdao = new PerformancesDAOImpl();
        Performances performance = (Performances) sdao.read(id);
       Logger.getLogger(AddLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  performance.getName();
    }

    @Override
    public synchronized void savePerformance(Performances performance) {
        PerformancesDAO bdao = new PerformancesDAOImpl();
         if(performance.getId() == 0) {
             Logger.getLogger(AddLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", performance.toString());
             bdao.create(performance);
         } else {
             Logger.getLogger(AddLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о товаре");
             bdao.update(performance);
         } 
    }

    @Override
    public List getAllGenre() {
        GenreDAO sdao = new GenreDAOImpl();
        return sdao.getGenre();
    }

    @Override
    public String getNameGenre(int id) {
        GenreDAO sdao = new GenreDAOImpl();
        Genres genre = (Genres) sdao.read(id);
        Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  genre.getGenre();
    }

    @Override
    public int getGenreId(String name) {
        GenreDAO sdao = new GenreDAOImpl();
        Genres genre = (Genres) sdao.getGenreByName(name);
        Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "Отправка ID спектакля");
        return  genre.getId();
    }
    
}
