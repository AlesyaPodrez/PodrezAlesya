package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.UserDAO;
import by.bsuir.podrez.database.DAO.UserDAOImpl;
import by.bsuir.podrez.database.model.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserLogicImpl implements UserLogic{

    @Override
    public String getLogin(int id) {
        UserDAO sdao = new UserDAOImpl();
        User user = (User) sdao.read(id);
        Logger.getLogger(UserLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  user.getLogin();
    }

    @Override
    public List getAllUsers() {
        UserDAO sdao = new UserDAOImpl();
        return sdao.getUsers();
    }

    @Override
    public void deleteUser(User user) {
        UserDAO bdao = new UserDAOImpl();
        bdao.delete(user.getId());
    }

    @Override
    public int getUserId(String name) {
        UserDAO sdao = new UserDAOImpl();
        User user = (User) sdao.getUserByName(name);
        Logger.getLogger(UserLogicImpl.class.getName()).log(Level.SEVERE, "Р С›РЎвЂљР С—РЎР‚Р В°Р Р†Р С”Р В° ID РЎРѓР С—Р ВµР С”РЎвЂљР В°Р С”Р В»РЎРЏ");
        return  user.getId();
    }

    @Override
    public void saveUser(User user) {
        UserDAO bdao = new UserDAOImpl();
         if(user.getId() == 0) {
             Logger.getLogger(UserLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", user.toString());
             bdao.create(user);
         } else {
             Logger.getLogger(AddTimetableLogicImpl.class.getName()).log(Level.SEVERE, "РћР±РЅРѕРІР»РµРЅРёРµ РґР°РЅРЅС‹С… Рѕ Р°РєС‚РµСЂРµ");
             bdao.update(user);
         } 
    }
}
