package fr.utbm.lo54.coursesmanager.core.controller;

import java.util.List;

import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;
import fr.utbm.lo54.coursesmanager.core.service.CourseSessionService;

public class CourseSessionController {

    public void saveCourseSession( CourseSession courseSession ) {
        CourseSessionService courseSessionService = new CourseSessionService();
        courseSessionService.createCourseSession( courseSession );
    }

    public List<CourseSession> showListCourseSessions() {
        CourseSessionService courseSessionService = new CourseSessionService();
        List<CourseSession> courseSessionsList = courseSessionService.getListCourseSessions();
        return courseSessionsList;

    }
}
