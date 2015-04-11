package fr.utbm.lo54.coursesmanager.core.entity;

public class Location {

    private Long   id;
    private String city;

    public Location() {
    }

    public Location( String cty ) {
        city = cty;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }
}
