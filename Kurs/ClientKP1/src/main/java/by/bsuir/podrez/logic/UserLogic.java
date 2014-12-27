package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.User;
import java.io.Serializable;
import java.util.List;

public interface UserLogic extends Serializable{
    
    public String getLogin(int id);

    public List getAllUsers();
    
    public void deleteUser(User user);
    
    public int getUserId(String name);
     public void saveUser(User user);
}
