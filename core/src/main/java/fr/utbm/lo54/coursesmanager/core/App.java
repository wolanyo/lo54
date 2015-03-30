package fr.utbm.lo54.coursesmanager.core;

import fr.utbm.lo54.coursesmanager.core.controller.CourseController;
import fr.utbm.lo54.coursesmanager.core.entity.Course;

public class App {

    public static void main(String[] args) {
        Course course = new Course();
        CourseController courseController = new CourseController();
        courseController.CourseControllerInput(course);
    }
}
