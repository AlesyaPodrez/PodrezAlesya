package by.bsuir.podrez.database.model;

import java.io.Serializable;
import java.util.Objects;


public class Ticket extends DataBaseObject implements Serializable{
    private int id_performance;
    private String amount_ticket;

    public Ticket(){}
    
    public Ticket(int id){
        this.setId(id);
    }
    
    public int getId_performance() {
        return id_performance;
    }

    public String getAmount_ticket() {
        return amount_ticket;
    }

    public void setId_performance(int id_performance) {
        this.id_performance = id_performance;
    }

    public void setAmount_ticket(String amount_ticket) {
        this.amount_ticket = amount_ticket;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.getId();
        hash = 71 * hash + this.id_performance;
        hash = 71 * hash + Objects.hashCode(this.amount_ticket);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        
        if (this.id_performance != other.id_performance) {
            return false;
        }
        if (!Objects.equals(this.amount_ticket, other.amount_ticket)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id="+ "id_performance=" + id_performance + ", amount_ticket=" + amount_ticket + '}';
    }
    
    
}
