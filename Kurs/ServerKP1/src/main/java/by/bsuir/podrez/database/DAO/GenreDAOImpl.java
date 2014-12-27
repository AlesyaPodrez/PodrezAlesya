package by.bsuir.podrez.database.DAO;

import by.bsuir.podrez.database.DBConnectionPool;
import by.bsuir.podrez.database.model.Actors;
import by.bsuir.podrez.database.model.DataBaseObject;
import by.bsuir.podrez.database.model.Genres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenreDAOImpl implements GenreDAO{

       @Override
    public int create(DataBaseObject object) {
        Genres genre = (Genres) object;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("INSERT INTO genre (genre, age_limit) VALUES (?,?)");
            ps.setString(1, genre.getGenre());
            ps.setString(2, genre.getAge_limit());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
        return 0;
    }

    @Override
    public DataBaseObject read(int id) {
        Genres genre = new Genres(id);
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT genre, age_limit FROM genre WHERE id_genre = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            genre.setGenre(rs.getString("genre"));
            genre.setAge_limit(rs.getString("age_limit"));
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return genre;
    }

    @Override
    public void update(DataBaseObject newObject) {
        Genres newGenre = (Genres) newObject;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("UPDATE genre SET genre = ?, age_limit = ? WHERE id_genre = ?");
            ps.setString(1, newGenre.getGenre());
            ps.setString(2, newGenre.getAge_limit());
            ps.setInt(3, newGenre.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            ps = connection.prepareStatement("DELETE FROM genre WHERE id_genre = ?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, null);
        }
    }

    @Override
    public List getGenre() {
        Genres genre = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List genres = new ArrayList();
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT * FROM genre");
            rs = ps.executeQuery();
            while(rs.next()) {
                genre = new Genres(rs.getInt("id_genre"));
                genre.setGenre(rs.getString("genre"));
                genre.setAge_limit(rs.getString("age_limit"));
                genres.add(genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return genres;
    }

    @Override
    public DataBaseObject getGenreByName(String name) {
        Genres genre = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_genre, genre FROM genre WHERE genre = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            System.out.println(name);
            rs.next();
            genre = new Genres(rs.getInt("id_genre"));
            genre.setGenre(rs.getString("genre"));
            //actor.setName(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return genre;
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
            Logger.getLogger(GenreDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getId_genre(String str) {
       Genres genre = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_genre FROM genre WHERE genre = ?");
            ps.setString(1, str);
            rs = ps.executeQuery();
            rs.next();
            genre = new Genres(rs.getInt("id_genre"));
            
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return genre.getId();
    }

    @Override
    public String getId_age(String str) {
        Genres genre = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = dbcp.getConnection();
            ps = connection.prepareStatement("SELECT id_genre, age_limit FROM genre WHERE age_limit = ?");
            ps.setString(1, str);
            rs = ps.executeQuery();
            rs.next();
            genre = new Genres(rs.getInt("id_genre"));
            genre.setAge_limit(rs.getString("age_limit"));
            
        } catch (SQLException ex) {
            Logger.getLogger(PerformancesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return genre.getAge_limit();
    }

    @Override
    public List getGenreAge(String age) {
        Genres genre = null;
        Connection connection = null;
        DBConnectionPool dbcp = DBConnectionPool.init();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List genres = new ArrayList();
        try{
            connection = dbcp.getConnection();
             ps = connection.prepareStatement("SELECT * FROM genre WHERE age_limit = ?");
            ps.setString(1, age);
            rs = ps.executeQuery();
            while(rs.next()) {
                genre = new Genres(rs.getInt("id_genre"));
                genre.setGenre(rs.getString("genre"));
                genre.setAge_limit(rs.getString("age_limit"));
                genres.add(genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActorsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbcp.freeConnection(connection);
            finallyBlock(ps, rs);
        }
        return genres;
    }
   
}
