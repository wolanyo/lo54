package fr.utbm.lo54.coursesmanager.core;

import fr.utbm.lo54.coursesmanager.core.controller.CourseController;

public class App {

    public static void main( String[] args ) {

        CourseController courseController = new CourseController();

        // courseController.registerCoursefromConsoleInput();

        courseController.showlistofCourses();

    }
}
