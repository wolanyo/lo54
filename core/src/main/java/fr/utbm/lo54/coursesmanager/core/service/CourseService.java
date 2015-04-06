package fr.utbm.lo54.coursesmanager.core.service;

import java.util.Set;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.repository.HibernateCourseDAO;

public class CourseService {

    // service pour recupérer la liste Course
    public Set<Course> getListCOurse() {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        Set<Course> hibernateCourse = hibernatecourseDao.getList();
        return hibernateCourse;
    }

    // service pour enregistrer un course
    public void registerCourse( Course course ) {
        HibernateCourseDAO hibernatecourseDao = new HibernateCourseDAO();
        hibernatecourseDao.save( course );
    }

    // get a Course by ID
    public Course getCourse( Integer id ) {
        return null; // replace null by a Client object
    }

}
