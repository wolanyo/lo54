/**
 *
 */
package fr.utbm.lo54.coursesmanager.core.controller;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.service.*;
import java.util.Scanner;

/**
 * @author kemour
 *
 */
public class CourseController {

    public void CourseControllerInput(Course course) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Course Code :");
        String code = sc.nextLine();
        //
        System.out.println("Course Title :");
        String titre = sc.nextLine();

        course.setCode(code);
        course.setTitle(titre);
        
        CourseService courseService = new CourseService();
        courseService.registerCourse(course);
    }
}
