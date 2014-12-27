package by.bsuir.podrez.database.model;

import java.io.Serializable;
import java.util.Objects;

public class Actors extends DataBaseObject implements Serializable{
    
    private int id_performance;
    private String surname;
    private String name;
    private String lastname; 
    
    public Actors(){}
    
    public Actors(int id){
        this.setId(id);
    }
    
    
    public void setId_performance(int id_performance) {
        this.id_performance = id_performance;
        
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId_performance() {
        return id_performance;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getActor(){   
        return surname;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.getId();
        hash = 97 * hash + this.id_performance;
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.lastname);
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
        final Actors other = (Actors) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        
        if (this.id_performance != other.id_performance) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actors{" + "id="+ "id_performance=" + id_performance + ", surname=" + surname + ", name=" + name + ", lastname=" + lastname + '}';
    }
    
}
