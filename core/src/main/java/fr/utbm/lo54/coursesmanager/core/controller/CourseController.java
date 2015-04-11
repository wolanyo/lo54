package fr.utbm.lo54.coursesmanager.core.controller;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.service.CourseService;

public class CourseController {

    public void saveCourse( Course course ) {
        CourseService courseService = new CourseService();
        courseService.createCourse( course );
    }

    public List<Course> showListCourses() {
        CourseService courseService = new CourseService();
        List<Course> coursesList = courseService.getListCourses();
        return coursesList;

    }
}
