package fr.utbm.lo54.coursesmanager.core.service;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.Location;
import fr.utbm.lo54.coursesmanager.core.repository.HibernateLocationDAO;
import java.util.ArrayList;
import java.util.Set;

public class LocationService {

    // service to get the list of locations
    public List<Location> getListLocations() {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        Set<Location> r = hibernatelocationDao.getList();
        List<Location> locationsList = new ArrayList<Location>();
        locationsList.addAll(r);
        return locationsList;
    }

    // service to get a update by ID
    public Location getLocation(Long id) {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        Location location = hibernatelocationDao.getById(id);
        return location;
    }

    // service to create, delete and update location
    public void createLocation(Location location) {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        hibernatelocationDao.create(location);
    }

    public void update(Location location) {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        hibernatelocationDao.update(location);
    }

    public void delete(Location location) {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        hibernatelocationDao.delete(location);
    }

}
