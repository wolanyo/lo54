package fr.utbm.lo54.coursesmanager.core.service;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.Location;
import fr.utbm.lo54.coursesmanager.core.repository.HibernateLocationDAO;

public class LocationService {

    // service to get the list of locations

    public List<Location> getListLocations() {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        List<Location> locationsList = hibernatelocationDao.getAllLocations();

        return locationsList;
    }

    // service to get a Location by ID

    public Location getLocation( Long id ) {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        Location location = hibernatelocationDao.getLocationById( id );
        return location;
    }

    // service to create, delete and update location

    public void createLocation( Location location ) {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        hibernatelocationDao.createLocation( location );
    }

    public void update( Location location ) {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        hibernatelocationDao.updateLocation( location );
    }

    public void delete( Location location ) {
        HibernateLocationDAO hibernatelocationDao = new HibernateLocationDAO();
        hibernatelocationDao.deleteLocation( location );
    }

}
