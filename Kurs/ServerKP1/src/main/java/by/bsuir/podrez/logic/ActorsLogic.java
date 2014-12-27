package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.Actors;
import java.io.Serializable;
import java.util.List;

public interface ActorsLogic extends Serializable{
    public List getAllActors();
 
    public void deleteActor(Actors actor);
    public int searchActor(String str);
}
