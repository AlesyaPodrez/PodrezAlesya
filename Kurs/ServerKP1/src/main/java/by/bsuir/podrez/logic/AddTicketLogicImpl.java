package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.PerformancesDAO;
import by.bsuir.podrez.database.DAO.PerformancesDAOImpl;
import by.bsuir.podrez.database.DAO.TicketDAO;
import by.bsuir.podrez.database.DAO.TicketDAOImpl;
import by.bsuir.podrez.database.model.Performances;
import by.bsuir.podrez.database.model.Ticket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddTicketLogicImpl implements AddTicketLogic{

    @Override
    public String getNamePerformance(int id) {
        PerformancesDAO sdao = new PerformancesDAOImpl();
        Performances performance = (Performances) sdao.read(id);
        Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  performance.getName();
    }

    @Override
    public String getNameTicket(int id) {
         TicketDAO sdao = new TicketDAOImpl();
        Ticket ticket = (Ticket) sdao.read(id);
       Logger.getLogger(AddTicketLogicImpl.class.getName()).log(Level.SEVERE, "\u041e\u0442\u043f\u0440\u0430\u0432\u043a\u0430 \u0438\u043c\u0435\u043d\u0438 \u043f\u0440\u043e\u0434\u0430\u0432\u0446\u0430{0}");
        return  ticket.getAmount_ticket();
    }

    @Override
    public List getAllPerformances() {
        PerformancesDAO sdao = new PerformancesDAOImpl();
        return sdao.getPerformanse();
    }

    @Override
    public void saveTicket(Ticket ticket) {
        TicketDAO bdao = new TicketDAOImpl();
         if(ticket.getId() == 0) {
             Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "\u0421\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u0438\u0435 \u043d\u043e\u0432\u043e\u0433\u043e \u0442\u043e\u0432\u0430\u0440\u0430{0}", ticket.toString());
             bdao.create(ticket);
         } else {
             Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "Обновление данных о актере");
             bdao.update(ticket);
         } 
    }

    @Override
    public int getPerformanceId(String name) {
         PerformancesDAO sdao = new PerformancesDAOImpl();
        Performances performance = (Performances) sdao.getPerformanceByName(name);
        Logger.getLogger(AddActorsLogicImpl.class.getName()).log(Level.SEVERE, "Отправка ID спектакля");
        return  performance.getId();
    }
    
}
