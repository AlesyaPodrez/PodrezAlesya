package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.DBConnectionPool;
import by.bsuir.podrez.database.model.DataBaseObject;
import by.bsuir.podrez.database.model.Performances;
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

public class PerformancesDAOImpl implements PerformancesDAO{

    @Override
    public List getPerformanse() {
        Performances performance = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List performances = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM performances");
            rs = ps.executeQuery();
            while(rs.next()) {
                performance = new Performances(rs.getInt("id"));
                performance.setName(rs.getString("name_performance"));
                performance.setId_genre(rs.getInt("id_genre"));
                performances.add(performance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return performances;
    }
    
    @Override
    public int create(DataBaseObject object) {
        Performances performance = (Performances) object;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO performances (name_performance, id_genre) VALUES (?, ?)");
            ps.setString(1, performance.getName());
            ps.setInt(2, performance.getId_genre());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DataBaseObject read(int id) {
        Performances performance = new Performances(id);
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT name_performance, id_genre FROM performances WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            performance.setName(rs.getString("name_performance"));
            performance.setId_genre(rs.getInt("id_genre"));
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return performance;
    }

    @Override
    public void update(DataBaseObject newObject) {
        Performances newPerformance = (Performances) newObject;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE performances SET name_performance = ?, id_genre = ? WHERE id = ?");
            ps.setString(1, newPerformance.getName());
            ps.setInt(2, newPerformance.getId_genre());
            ps.setInt(3, newObject.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = connection.prepareStatement("DELETE FROM performances WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DataBaseObject getPerformanceByName(String name) {
        Performances performance = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id, name_performance FROM performances WHERE name_performance = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            rs.next();
            performance = new Performances(rs.getInt("id"));
            performance.setName(rs.getString("name_performance"));
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return performance;
    }

    @Override
    public int getId_performance(String str) {
        Performances performance = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id FROM performances WHERE name_performance = ?");
            ps.setString(1, str);
            rs = ps.executeQuery();
            rs.next();
            performance = new Performances(rs.getInt("id"));
            
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return performance.getId();
    }

    @Override
    public List getPerformanceGenre(int id) {
        Performances performance = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List performances = new ArrayList();
        try{
            connection = dbcp.getConnection();
             ps = connection.prepareStatement("SELECT * FROM performances WHERE id_genre = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                performance = new Performances(rs.getInt("id"));
                performance.setName(rs.getString("name_performance"));
                performance.setId_genre(rs.getInt("id_genre"));
                performances.add(performance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return performances;
    }
    
}
