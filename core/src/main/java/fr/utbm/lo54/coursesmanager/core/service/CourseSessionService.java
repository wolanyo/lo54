/**
 * 
 */
package fr.utbm.lo54.coursesmanager.core.service;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;
import fr.utbm.lo54.coursesmanager.core.repository.HibernateCourseSessionDAO;

/**
 * @author kemour
 *
 */
public class CourseSessionService {

    // service to get the list of courseSessions

    public List<CourseSession> getListCourseSessions() {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        List<CourseSession> courseSessionsList = hibernatecourseSessionDao.getAllCoursesSession();

        return courseSessionsList;
    }

    public List<CourseSession> getCourseSessionsByCourse( String courseCode ) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        List<CourseSession> courseSessionsList = hibernatecourseSessionDao.getCoursesSessionByCourse( courseCode );

        return courseSessionsList;
    }

    public CourseSession getCourseSessionById( Long id ) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        CourseSession courseSession = hibernatecourseSessionDao.getCourseSessionById( id );

        return courseSession;
    }

    // service to get a CourseSession by ID

    // public CourseSession getCourseSession( String id ) {
    // HibernateCourseSessionDAO hibernatecourseSessionDao = new
    // HibernateCourseSessionDAO();
    // CourseSession courseSession =
    // hibernatecourseSessionDao.getCourseSessionById( id );
    // return courseSession;
    // }

    // service to create, delete and update courseSession

    public void createCourseSession( CourseSession courseSession ) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        hibernatecourseSessionDao.createCourseSession( courseSession );
    }

    public void update( CourseSession courseSession ) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        hibernatecourseSessionDao.updateCourseSession( courseSession );
    }

    public void delete( CourseSession courseSession ) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        hibernatecourseSessionDao.deleteCourseSession( courseSession );
    }

}
