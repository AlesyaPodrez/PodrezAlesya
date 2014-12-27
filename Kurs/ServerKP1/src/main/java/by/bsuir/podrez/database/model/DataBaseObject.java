package by.bsuir.podrez.database.model;

public abstract class DataBaseObject {
    
    private int id;

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DataBaseObject{" + "id=" + id + '}';
    }

}
