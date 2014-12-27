package by.bsuir.podrez.database.model;

import java.io.Serializable;
import java.util.Objects;

public class Genres extends DataBaseObject implements Serializable{
    
    private int id_genre;
    private String genre;
    private String age_limit; 
    
    public Genres(){}
    
    public Genres(int id){
        this.setId(id);
    }

    public int getId_genre() {
        return id_genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getAge_limit() {
        return age_limit;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAge_limit(String age_limit) {
        this.age_limit = age_limit;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.getId();
        hash = 97 * hash + this.id_genre;
        hash = 97 * hash + Objects.hashCode(this.genre);
        hash = 97 * hash + Objects.hashCode(this.age_limit);
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
        final Genres other = (Genres) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        
        if (this.id_genre != other.id_genre) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.age_limit, other.age_limit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Genres{" + "id="+ "id_genre=" + id_genre + ", genre=" + genre + ", age_limit=" + age_limit + '}';
    }
}
