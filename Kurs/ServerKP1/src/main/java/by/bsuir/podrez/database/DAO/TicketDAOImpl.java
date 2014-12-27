package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.DBConnectionPool;
import by.bsuir.podrez.database.model.Actors;
import by.bsuir.podrez.database.model.DataBaseObject;
import by.bsuir.podrez.database.model.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketDAOImpl implements TicketDAO{

    @Override
    public List getTicket() {
        Ticket ticket = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List tickets = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM unsold_tickets");
            rs = ps.executeQuery();
            while(rs.next()) {
                ticket = new Ticket(rs.getInt("id"));
                ticket.setId_performance(rs.getInt("id_performance"));
                ticket.setAmount_ticket(rs.getString("amount_tickets"));
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return tickets;
    }

    @Override
    public int create(DataBaseObject object) {
        Ticket ticket = (Ticket) object;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO unsold_tickets (id_performance, amount_tickets) VALUES (?,?)");
             ps.setInt(1, ticket.getId_performance());
            ps.setString(2, ticket.getAmount_ticket());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DataBaseObject read(int id) {
        Ticket ticket = new Ticket(id);
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_performance, amount_tickets FROM unsold_tickets WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            ticket.setId_performance(rs.getInt("id_performance"));
            ticket.setAmount_ticket(rs.getString("amount_tickets"));
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return ticket;
    }

    @Override
    public void update(DataBaseObject newObject) {
        Ticket newTicket = (Ticket) newObject;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE unsold_tickets SET id_performance = ?, amount_tickets = ? WHERE id = ?");
            ps.setInt   (1, newTicket.getId_performance());
            ps.setString(2, newTicket.getAmount_ticket());
            ps.setInt   (3, newTicket.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("DELETE FROM unsold_tickets WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    private void finallyBlock(PreparedStatement ps, ResultSet rs) {
        try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
