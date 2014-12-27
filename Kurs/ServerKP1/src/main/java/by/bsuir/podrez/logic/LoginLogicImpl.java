package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.UserDAO;
import by.bsuir.podrez.database.DAO.UserDAOImpl;
import by.bsuir.podrez.database.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginLogicImpl implements LoginLogic{

    @Override
    public boolean login(String login, String pass) {
         UserDAO udao = new UserDAOImpl();
        User user = (User) udao.getUserByName(login);
        if(user != null) {
            if(pass.equals(user.getPass())){
                Logger.getLogger("Аутификация пройдена пользователем: " + login);
                return true;
            }
        }
        Logger.getLogger(LoginLogicImpl.class.getName()).log(Level.SEVERE, "Аутификация не пройдена");
        return false;
    }
    }

