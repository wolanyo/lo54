/**
 *
 */
package fr.utbm.lo54.coursesmanager.core.service;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;
import fr.utbm.lo54.coursesmanager.core.repository.HibernateCourseSessionDAO;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author kemour
 *
 */
public class CourseSessionService {

    // service to get the list of courseSessions
    public List<CourseSession> getListCourseSessions() {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        Set<CourseSession> r = hibernatecourseSessionDao.getList();
        List<CourseSession> courseSessionsList = new ArrayList<CourseSession>();
        courseSessionsList.addAll(r);
        return courseSessionsList;
    }

    public List<CourseSession> getCourseSessionsByCourse(String courseCode) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        List<CourseSession> courseSessionsList = hibernatecourseSessionDao.getCoursesSessionByCourse(courseCode);

        return courseSessionsList;
    }

    public CourseSession getCourseSessionById(Long id) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        CourseSession courseSession = hibernatecourseSessionDao.getById(id);

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
    public void createCourseSession(CourseSession courseSession) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        hibernatecourseSessionDao.create(courseSession);
    }

    public void update(CourseSession courseSession) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        hibernatecourseSessionDao.update(courseSession);
    }

    public void delete(CourseSession courseSession) {
        HibernateCourseSessionDAO hibernatecourseSessionDao = new HibernateCourseSessionDAO();
        hibernatecourseSessionDao.delete(courseSession);
    }

}
