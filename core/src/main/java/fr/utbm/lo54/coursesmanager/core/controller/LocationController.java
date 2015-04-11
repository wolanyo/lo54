package fr.utbm.lo54.coursesmanager.core.controller;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.Location;
import fr.utbm.lo54.coursesmanager.core.service.LocationService;

public class LocationController {

    public void saveLocation( Location location ) {
        LocationService locationService = new LocationService();
        locationService.createLocation( location );
    }

    public List<Location> showListLocations() {
        LocationService locationService = new LocationService();
        List<Location> locationsList = locationService.getListLocations();
        return locationsList;

    }

}
