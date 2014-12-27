package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.DBConnectionPool;
import by.bsuir.podrez.database.model.Actors;
import by.bsuir.podrez.database.model.DataBaseObject;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActorsDAOImpl implements ActorsDAO{

    @Override
    
    public List getActor() {
        Actors actor = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List actors = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM actors");
            rs = ps.executeQuery();
            while(rs.next()) {
                actor = new Actors(rs.getInt("id_actor"));
                actor.setId_performance(rs.getInt("id_performance"));
                actor.setSurname(rs.getString("surname"));
                actor.setName(rs.getString("name"));
                actor.setLastname(rs.getString("lastname"));
                actors.add(actor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return actors;
    }
    
    @Override
    public int create(DataBaseObject object) {
        Actors actor = (Actors) object;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO actors (id_performance, surname, name, lastname) VALUES (?,?,?,?)");
             ps.setInt(1, actor.getId_performance());
            ps.setString(2, actor.getSurname());
            ps.setString(3, actor.getName());
            ps.setString(4, actor.getLastname());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }
    
@Override
    public DataBaseObject read(int id) {
        Actors actor = new Actors(id);
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_performance, surname, name, lastname FROM actors WHERE id_actor = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            actor.setId_performance(rs.getInt("id_performance"));
            actor.setSurname(rs.getString("surname"));
            actor.setName(rs.getString("name"));
            actor.setLastname(rs.getString("lastname"));
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return actor;
    }
    
@Override
    public void update(DataBaseObject newObject) {
        Actors newActor = (Actors) newObject;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE actors SET id_performance = ?, surname = ?, name = ?, lastname = ? WHERE id_actor = ?");
            ps.setInt   (1, newActor.getId_performance());
            ps.setString(2, newActor.getSurname());
            ps.setString(3, newActor.getName());
            ps.setString(4, newActor.getLastname());
            ps.setInt   (5, newActor.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = connection.prepareStatement("DELETE FROM actors WHERE id_actor = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public DataBaseObject getActorByName(String name) {
       Actors actor = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_actor, surname FROM actors WHERE surname = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            System.out.println(name);
            rs.next();
            actor = new Actors(rs.getInt("id_actor"));
            actor.setSurname(rs.getString("surname"));
            //actor.setName(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return actor;
    }

    @Override
    public int getId_actor(String str) {
        Actors actor = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_actor FROM actors WHERE surname = ?");
            ps.setString(1, str);
            rs = ps.executeQuery();
            rs.next();
            actor = new Actors(rs.getInt("id_actor"));
            
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return actor.getId();
    }
    }

