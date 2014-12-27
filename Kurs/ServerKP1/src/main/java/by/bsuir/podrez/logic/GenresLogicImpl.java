package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.GenreDAO;
import by.bsuir.podrez.database.DAO.GenreDAOImpl;
import by.bsuir.podrez.database.model.Actors;
import by.bsuir.podrez.database.model.Genres;
import java.util.List;

public class GenresLogicImpl implements GenresLogic{

    @Override
    public List getAllGenres() {
        GenreDAO sdao = new GenreDAOImpl();
        return sdao.getGenre();
    }

    @Override
    public void deleteGenre(Genres genre) {
        GenreDAO bdao = new GenreDAOImpl();
        bdao.delete(genre.getId());
    }

    @Override
    public int searchGenre(String str) {
        GenreDAO bdao = new GenreDAOImpl();
        return bdao.getId_genre(str);
    }

    @Override
    public String searchAge(String str) {
         GenreDAO bdao = new GenreDAOImpl();
        return bdao.getId_age(str);
    }

    @Override
    public List filterGenre(String age) {
        GenreDAO sdao = new GenreDAOImpl();
        return sdao.getGenreAge(age);
    }
    
}
