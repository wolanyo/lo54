package fr.utbm.lo54.coursesmanager.core;

import java.util.Iterator;

import fr.utbm.lo54.coursesmanager.core.controller.CourseController;
import fr.utbm.lo54.coursesmanager.core.controller.CourseSessionController;
import fr.utbm.lo54.coursesmanager.core.controller.LocationController;
import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;

public class App {

    public static void main( String[] args ) {

        CourseController courseController = new CourseController();
        LocationController locationController = new LocationController();
        CourseSessionController CcourseSessionController = new CourseSessionController();

        // register from console

        // Scanner sc = new Scanner( System.in );
        // System.out.println( "Course Code :" );
        // String code = sc.nextLine();
        // System.out.println( "Course Title :" );
        // String titre = sc.nextLine();
        // Course course = new Course();
        // course.setCode( code );
        // course.setTitle( titre );
        // courseController.registerCourse( course );

        // afficher la liste des cours
        /*
         * System.out.println( "\nParcours de la liste de cours" );
         * Iterator<Course> it = courseController.showListCourses().iterator();
         * System.out.println( "-----------------------------------" ); while (
         * it.hasNext() ) { Course crs = (Course) it.next(); System.out.println(
         * "code = " + crs.getCode() + " -> title = " + crs.getTitle() ); }
         */

        // afficher la liste des SESSIONS
        System.out.println( "\nParcours de la liste de session" );
        Iterator<CourseSession> it3 = CcourseSessionController.showListCourseSessions().iterator();
        System.out.println( "-----------------------------------" );
        while ( it3.hasNext() ) {
            CourseSession cs = (CourseSession) it3.next();
            System.out.println(
                    "start_date = " + cs.getStartdate() +
                            "end_date = " + cs.getEnddate() +
                            "course_code = " + cs.getCourse() +
                            "course_code = " + cs.getCourse() );
        }
        // afficher la liste des Location
        /*
         * System.out.println( "\nParcours de la liste de Location" );
         * Iterator<Location> it2 =
         * locationController.showListLocations().iterator();
         * System.out.println( "-----------------------------------" ); while (
         * it2.hasNext() ) { Location lct = (Location) it2.next();
         * System.out.println( "id = " + lct.getId() + " -> title = " +
         * lct.getCity() ); }
         */
    }
}
