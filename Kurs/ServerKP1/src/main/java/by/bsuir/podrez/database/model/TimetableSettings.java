package by.bsuir.podrez.database.model;

import java.io.Serializable;
import java.util.Objects;

public class TimetableSettings extends DataBaseObject implements Serializable{
    
    private int id_performance;
    private int id_actors;
    private String date_setting;
    private String time_ofthe;
    
    public TimetableSettings(){}
    
    public TimetableSettings(int id){
        this.setId(id);
    }

    public int getId_performance() {
        return id_performance;
    }

    public int getId_actors() {
        return id_actors;
    }

    public String getDate_setting() {
        return date_setting;
    }

    public String getTime_ofthe() {
        return time_ofthe;
    }

    public void setId_performance(int id_performance) {
        this.id_performance = id_performance;
    }

    public void setId_actors(int id_actors) {
        this.id_actors = id_actors;
    }

    public void setDate_setting(String date_setting) {
        this.date_setting = date_setting;
    }

    public void setTime_ofthe(String time_ofthe) {
        this.time_ofthe = time_ofthe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.getId();
        hash = 73 * hash + Objects.hashCode(this.id_performance);
        hash = 73 * hash + Objects.hashCode(this.id_actors);
        hash = 73 * hash + Objects.hashCode(this.date_setting);
        hash = 73 * hash + Objects.hashCode(this.time_ofthe);
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
        final TimetableSettings other = (TimetableSettings) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        
        if (!Objects.equals(this.id_performance, other.id_performance)) {
            return false;
        }
        if (!Objects.equals(this.id_actors, other.id_actors)) {
            return false;
        }
        if (!Objects.equals(this.date_setting, other.date_setting)) {
            return false;
        }
        if (!Objects.equals(this.time_ofthe, other.time_ofthe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TimetableSettings{"+ "id=" + "name_performance=" + id_performance + ", participating_actors=" + id_actors + ", date_setting=" + date_setting + ", time_ofthe=" + time_ofthe + '}';
    }   
}
