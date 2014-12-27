package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.ActorsDAO;
import by.bsuir.podrez.database.DAO.ActorsDAOImpl;
import by.bsuir.podrez.database.model.Actors;
import java.util.List;


public class ActorsLogicImpl implements ActorsLogic{

    @Override
    public List getAllActors() {
        ActorsDAO sdao = new ActorsDAOImpl();
        return sdao.getActor();
    }

    @Override
    public void deleteActor(Actors actor) {
        ActorsDAO bdao = new ActorsDAOImpl();
        bdao.delete(actor.getId());
    }

    @Override
    public int searchActor(String str) {
        ActorsDAO bdao = new ActorsDAOImpl();
        return bdao.getId_actor(str);
    }
    
}
