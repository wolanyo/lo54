package fr.utbm.lo54.coursesmanager.core.service;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.repository.HibernateCourseDAO;
import java.util.ArrayList;
import java.util.Set;

public class CourseService {

    // service to get the list of courses
    public List<Course> getListCourses() {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        // Set<Course> hibernateCourse = hibernatecourseDao.getCourseList();
        Set<Course> r = hibernatecourseDao.getList();
        List<Course> coursesList = new ArrayList<Course>();
        coursesList.addAll(r);
        return coursesList;
    }

    // service to get a Course by ID
    public Course getCourse(String id) {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        Course course = hibernatecourseDao.getById(id);
        return course;
    }

    // service to create, delete and update course
    public void createCourse(Course course) {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        hibernatecourseDao.create(course);
    }

    public void update(Course course) {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        hibernatecourseDao.update(course);
    }

    public void delete(Course course) {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        hibernatecourseDao.delete(course);
    }

}
