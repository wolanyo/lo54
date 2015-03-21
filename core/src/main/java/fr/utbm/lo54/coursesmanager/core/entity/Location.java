/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.coursesmanager.core.entity;

/**
 *
 * @author fnac
 */

public class Location {

    private Integer id;
    private String city;

    public Location(Integer id, String city) {
        this.id = id;
        this.city = city;
    }
    
    public Location() {
        this.id = null;
        this.city = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
