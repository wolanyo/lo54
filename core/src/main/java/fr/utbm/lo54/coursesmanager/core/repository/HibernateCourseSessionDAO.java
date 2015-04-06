package fr.utbm.lo54.coursesmanager.core.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;

/**
 * @author kemour
 *
 */
public class HibernateCourseSessionDAO {

    private SessionFactory sessionFactory;

    public HibernateCourseSessionDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public HibernateCourseSessionDAO( SessionFactory ses ) {
        this.sessionFactory = ses;
    }

    /**
     * SAVE A COURSE SESSION
     * 
     * @param courseSession
     * @return
     */
    public CourseSession save( CourseSession courseSession ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save( courseSession );
            tx.commit();
        } catch ( HibernateException e ) {
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                try {
                    session.close();
                } catch ( HibernateException f ) {
                    f.printStackTrace();
                }
            }
        }
        return courseSession;
    }

    /**
     * GET LIST OF COURSESESSION
     * 
     * @return
     */
    public Set<CourseSession> getList() {
        Session session = this.sessionFactory.openSession();
        HashSet<CourseSession> courseSessions = new HashSet<CourseSession>();
        try {
            Query q = session.createQuery( "FROM CourseSession" );
            @SuppressWarnings( "unchecked" )
            List<CourseSession> courseSessionList = q.list();
            for ( CourseSession s : courseSessionList ) {
                courseSessions.add( s );
            }
        } catch ( HibernateException e ) {
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                try {
                    session.close();
                } catch ( HibernateException f ) {
                    f.printStackTrace();
                }
            }
        }
        return courseSessions;
    }

}
