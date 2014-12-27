package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.model.DataBaseObject;
import java.util.List;

public interface UserDAO extends DAO {
    public List getUsers();
    public DataBaseObject getUserByName(String name);
}
