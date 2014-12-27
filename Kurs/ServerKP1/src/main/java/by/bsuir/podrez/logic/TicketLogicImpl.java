package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.DAO.TicketDAO;
import by.bsuir.podrez.database.DAO.TicketDAOImpl;
import by.bsuir.podrez.database.model.Ticket;
import java.util.List;

public class TicketLogicImpl implements TicketLogic{

    @Override
    public List getAllTicket() {
        TicketDAO sdao = new TicketDAOImpl();
        return sdao.getTicket();
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        TicketDAO bdao = new TicketDAOImpl();
        bdao.delete(ticket.getId());
    }
    
}
