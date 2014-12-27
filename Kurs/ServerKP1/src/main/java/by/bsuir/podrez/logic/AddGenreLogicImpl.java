package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.GenreDAO;
import by.bsuir.podrez.database.DAO.GenreDAOImpl;
import by.bsuir.podrez.database.model.Genres;
import by.bsuir.podrez.database.model.Performances;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddGenreLogicImpl implements AddGenreLogic{

    @Override
    public String getNameGenre(int id) {
        GenreDAO sdao = new GenreDAOImpl();
        Genres genre = (Genres) sdao.read(id);
        Logger.getLogger(AddGenreLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  genre.getGenre();
    }

    @Override
    public List getAllGenres() {
        GenreDAO sdao = new GenreDAOImpl();
        return sdao.getGenre();
    }

    @Override
    public int getGenreId(String name) {
        GenreDAO sdao = new GenreDAOImpl();
        Genres genre = (Genres) sdao.getGenreByName(name);
        Logger.getLogger(AddGenreLogicImpl.class.getName()).log(Level.SEVERE, "Отправка ID спектакля");
        return  genre.getId();
    }

    @Override
    public void saveGenre(Genres genre) {
        GenreDAO bdao = new GenreDAOImpl();
         if(genre.getId() == 0) {
             Logger.getLogger(AddGenreLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", genre.toString());
             bdao.create(genre);
         } else {
             Logger.getLogger(AddGenreLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о актере");
             bdao.update(genre);
         } 
    }
    
}
