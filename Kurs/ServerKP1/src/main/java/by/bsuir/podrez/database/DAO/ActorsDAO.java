package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.model.DataBaseObject;
import java.util.List;

public interface ActorsDAO extends DAO{
    public List getActor();
    public DataBaseObject getActorByName( String name);
    public int getId_actor(String str);
}
