package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.Ticket;
import java.io.Serializable;
import java.util.List;

public interface TicketLogic extends Serializable{
    public List getAllTicket();
 
    public void deleteTicket(Ticket ticket);
}
