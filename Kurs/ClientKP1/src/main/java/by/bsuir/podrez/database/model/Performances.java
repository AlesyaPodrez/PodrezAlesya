package by.bsuir.podrez.database.model;

import java.io.Serializable;
import java.util.Objects;

public class Performances extends DataBaseObject implements Serializable {
    
    private String name_performance;
    private int id_genre;

    public Performances(){}
    
    public Performances(int id) {
        this.setId(id);
    }
    
    public String getName() {
        return name_performance;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setName(String name) {
        this.name_performance = name;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.getId();
        hash = 97 * hash + Objects.hashCode(this.name_performance);
        hash = 97 * hash + this.getId_genre();
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
        final Performances other = (Performances) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        
        if (!Objects.equals(this.name_performance, other.name_performance)) {
            return false;
        }
        if (this.getId_genre() != other.getId_genre()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Performances{" + "id="+ "name_performance=" + name_performance + "id_genre="+ id_genre +'}';
    }
}
