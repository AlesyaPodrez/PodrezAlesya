package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.DBConnectionPool;
import by.bsuir.podrez.database.model.DataBaseObject;
import by.bsuir.podrez.database.model.TimetableSettings;
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

public class TimetableSettingsDAOImpl implements TimetableSettingsDAO{

    @Override
    public List getTimetable() {
        TimetableSettings timetable = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List timetables = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM timetable_settings");
            rs = ps.executeQuery();
            while(rs.next()) {
                timetable = new TimetableSettings(rs.getInt("id"));
                timetable.setId_performance(rs.getInt("id_performance"));
                timetable.setId_actors(rs.getInt("id_actors"));
                timetable.setDate_setting(rs.getString("date_setting"));
                timetable.setTime_ofthe(rs.getString("time_ofthe"));
                timetables.add(timetable);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return timetables;
    }
   
     @Override
    public int create(DataBaseObject object) {
        TimetableSettings timetable = (TimetableSettings) object;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO timetable_settings (id_performance, id_actors, date_setting, time_ofthe) VALUES (?,?,?,?)");
            ps.setInt(1, timetable.getId_performance());
            ps.setInt(2, timetable.getId_actors());
            ps.setString(3, timetable.getDate_setting());
            ps.setString(4, timetable.getTime_ofthe());
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
        TimetableSettings timetable = new TimetableSettings(id);
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_performance, id_actors, date_setting, time_ofthe FROM SELLER WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            timetable.setId_performance(rs.getInt("id_performance"));
            timetable.setId_actors(rs.getInt("id_actors"));
            timetable.setDate_setting(rs.getString("date_setting"));
            timetable.setTime_ofthe(rs.getString("time_ofthe"));
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return timetable;
    }
    
     @Override
    public void update(DataBaseObject newObject) {
        TimetableSettings newTimetable = (TimetableSettings) newObject;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE timetable_settings SET id_performance = ?, id_actors = ?, date_setting = ?, time_ofthe = ? WHERE id = ?");
            ps.setInt   (1, newTimetable.getId_performance());
            ps.setInt(2, newTimetable.getId_actors());
            ps.setString(3, newTimetable.getDate_setting());
            ps.setString(4, newTimetable.getTime_ofthe());
            ps.setInt   (5, newTimetable.getId());
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
            ps = connection.prepareStatement("DELETE FROM timetable_settings WHERE id = ?");
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
    public List getTimetablePerformance(int id) {
       TimetableSettings timetable = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List timetables = new ArrayList();
        try{
            connection = dbcp.getConnection();
             ps = connection.prepareStatement("SELECT * FROM timetable_settings WHERE id_performance = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                timetable = new TimetableSettings(rs.getInt("id"));
                timetable.setId_performance(rs.getInt("id_performance"));
                timetable.setId_actors(rs.getInt("id_actors"));
                timetable.setDate_setting(rs.getString("date_setting"));
                timetable.setTime_ofthe(rs.getString("time_ofthe"));
                timetables.add(timetable);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return timetables;
    }

    @Override
    public List getTimetableActor(int id) {
        TimetableSettings timetable = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List timetables = new ArrayList();
        try{
            connection = dbcp.getConnection();
             ps = connection.prepareStatement("SELECT * FROM timetable_settings WHERE id_actors = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                timetable = new TimetableSettings(rs.getInt("id"));
                timetable.setId_performance(rs.getInt("id_performance"));
                timetable.setId_actors(rs.getInt("id_actors"));
                timetable.setDate_setting(rs.getString("date_setting"));
                timetable.setTime_ofthe(rs.getString("time_ofthe"));
                timetables.add(timetable);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return timetables;
    }

    
}
