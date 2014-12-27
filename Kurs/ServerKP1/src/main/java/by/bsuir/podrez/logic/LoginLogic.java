package by.bsuir.podrez.logic;

import java.io.Serializable;

public interface LoginLogic extends Serializable{
    
     public boolean login(String login, String pass);
}
