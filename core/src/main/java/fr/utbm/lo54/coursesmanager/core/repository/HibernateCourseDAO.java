package fr.utbm.lo54.coursesmanager.core.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;

public class HibernateCourseDAO {

    private SessionFactory sessionFactory;

    // instance of hibernate statistics showing with logSummary method
    Statistics             stats = HibernateUtil.getSessionFactory().getStatistics();

    public HibernateCourseDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public HibernateCourseDAO( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * SAVE an object Course in DataBase
     * 
     * @param course
     */
    public void save( Course course ) {
        Session session = this.sessionFactory.openSession(); // open session
        Transaction tx = null; // init a transaction for this query
        try {
            tx = session.beginTransaction(); // start transaction
            session.persist( course ); // save the course
            tx.commit(); // commit the transaction

        } catch ( HibernateException he ) {
            he.printStackTrace();
            if ( tx != null ) {
                try { // cancel transaction if all query does not execute
                    session.getTransaction().rollback();
                } catch ( HibernateException he2 ) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if ( session != null ) {
                try {
                    session.close(); // close session
                    stats.logSummary();
                } catch ( HibernateException he3 ) {
                    he3.printStackTrace();
                }
            }

        }
    }

    /**
     * GET LIST OF COURSE
     * 
     * @return a set of object courses
     */
    public Set<Course> getList() {
        Session session = this.sessionFactory.openSession();
        HashSet<Course> courses = new HashSet<Course>();
        try {
            Query q = session.createQuery( "from Course" );
            @SuppressWarnings( "unchecked" )
            List<Course> courseList = q.list(); // get resulset in List
            for ( Course c : courseList ) { // copy the list in the set
                courses.add( c );
            }
        } catch ( HibernateException e ) {
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                try {
                    session.close();
                    stats.logSummary();
                } catch ( HibernateException f ) {
                    f.printStackTrace();
                }
            }
        }
        return courses;
        // return courseList;
    }

    /**
     * GET AN OBJECT COURSE by ID
     * 
     * @param id
     * @return
     */
    public Course getById( Long id ) {
        Session session = this.sessionFactory.openSession();
        Course course = new Course();
        try {
            Query q = session.createQuery( "FROM Course WHERE id = :id" );
            q.setParameter( "id", id );
            course = (Course) q.uniqueResult();
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
        return course;
    }

    /**
     * UPDATE A COURSE
     * 
     * @param course
     * @return
     */
    public Course update( Course course ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge( course );
            tx.commit();
            session.flush();
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
        return course;
    }

    /**
     * DELETE A COURSE
     */
    public Course delete( Course course ) {
        Session session = this.sessionFactory.openSession();
        Transaction transact = null;
        try {
            transact = session.beginTransaction();
            session.delete( course );
            transact.commit();
            session.flush();
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
        course.setCode( null );
        return course;
    }

    /**
     * FILTER A LIST
     * 
     * @param keywords
     * @return
     */
    // to improve
    public List<CourseSession> filterByKeyword( List<String> keywords ) {
        Session session = this.sessionFactory.openSession();
        List<CourseSession> course_sessions = new ArrayList<CourseSession>();
        try {
            Query q = session.createQuery( "FROM CourseSession WHERE course.title in (:keys)" );
            q.setParameterList( "keys", keywords );

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
        return course_sessions;
    }

}
