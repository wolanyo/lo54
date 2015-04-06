package fr.utbm.lo54.coursesmanager.core.entity;

public class Location {

    private Integer id;
    private String  city;

    public Location() {
    }

    public Location( String cty ) {
        city = cty;
    }

    public Location( Integer id, String city ) {
        this.id = id;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }
}
