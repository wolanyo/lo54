package fr.utbm.lo54.coursesmanager.core.service;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.repository.HibernateCourseDAO;

public class CourseService {

    // service to get the list of courses

    public List<Course> getListCourses() {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        // Set<Course> hibernateCourse = hibernatecourseDao.getAllCourses();
        List<Course> coursesList = hibernatecourseDao.getAllCourses();

        return coursesList;
    }

    // service to get a Course by ID

    public Course getCourse( String id ) {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        Course course = hibernatecourseDao.getCourseById( id );
        return course;
    }

    // service to create, delete and update course

    public void createCourse( Course course ) {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        hibernatecourseDao.createCourse( course );
    }

    public void update( Course course ) {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        hibernatecourseDao.updateCourse( course );
    }

    public void delete( Course course ) {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        hibernatecourseDao.deleteCourse( course );
    }

}
