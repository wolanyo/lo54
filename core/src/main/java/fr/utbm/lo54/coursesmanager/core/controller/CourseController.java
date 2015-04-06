package fr.utbm.lo54.coursesmanager.core.controller;

import java.util.Iterator;
import java.util.Scanner;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.service.CourseService;

/**
 * @author kemour
 *
 */
public class CourseController {

    public void registerCoursefromConsoleInput() {

        Scanner sc = new Scanner( System.in );
        System.out.println( "Course Code :" );
        String code = sc.nextLine();
        System.out.println( "Course Title :" );
        String titre = sc.nextLine();

        Course course = new Course();
        course.setCode( code );
        course.setTitle( titre );

        CourseService courseService = new CourseService();
        courseService.registerCourse( course );

    }

    public void showlistofCourses() {
        // Test the show of List course
        CourseService courseService = new CourseService();

        Iterator<Course> it = courseService.getListCOurse().iterator();

        System.out.println( "\nParcours de la liste de résultats" );
        System.out.println( "-----------------------------------" );

        while ( it.hasNext() ) {
            Course crs = (Course) it.next();
            System.out.println( "code = " + crs.getCode() + " -> title = " + crs.getTitle() );
        }

    }
}
