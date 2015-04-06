package fr.utbm.lo54.coursesmanager.core.service;

import java.util.Set;

import fr.utbm.lo54.coursesmanager.core.entity.Location;
import fr.utbm.lo54.coursesmanager.core.repository.HibernateLocationDAO;

public class LocationService {

    /**
     * SAVE A LOCATION
     * 
     * @param location
     */
    public void registerLocation( Location location ) {
        HibernateLocationDAO hibernatelocationDAO = new HibernateLocationDAO();
        hibernatelocationDAO.save( location );

    }

    /**
     * get a location by ID
     * 
     */
    public static Location getLocation( long id ) {
        HibernateLocationDAO hibernatelocationDAO = new HibernateLocationDAO();
        Location location = hibernatelocationDAO.getById( id );
        return location;
    }

    /**
     * get a list of Location
     * 
     * @return
     */
    public static Set<Location> getList() {
        HibernateLocationDAO hibernatelocationDAO = new HibernateLocationDAO();
        Set<Location> location = hibernatelocationDAO.getList();
        return location;
    }

    /**
     * 
     * @param loc
     * @return
     */
    public static Location update( Location loc ) {
        HibernateLocationDAO hibernatelocationDAO = new HibernateLocationDAO();
        Location location = hibernatelocationDAO.update( loc );
        return location;
    }

    /**
     * 
     * @param loc
     * @return
     */
    public static Location delete( Location loc ) {
        HibernateLocationDAO hibernatelocationDAO = new HibernateLocationDAO();
        Location location = hibernatelocationDAO.delete( loc );
        return location;
    }

}
