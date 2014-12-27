package by.bsuir.podrez.logic;

import by.bsuir.podrez.database.model.Ticket;
import java.io.Serializable;
import java.util.List;

public interface AddTicketLogic extends Serializable{
    public String getNamePerformance(int id);
    
    public String getNameTicket(int id);
    
     public List getAllPerformances();
     
     public void saveTicket(Ticket ticket);
     
     public int getPerformanceId(String name);
}
