package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.model.DataBaseObject;
import java.io.Serializable;

public interface DAO extends Serializable{
    
    public int create(DataBaseObject object);
    public DataBaseObject read(int id);
    public void update(DataBaseObject newObject);
    public void delete(int id);
    
}
