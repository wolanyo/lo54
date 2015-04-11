package fr.utbm.lo54.coursesmanager.core.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;

/**
 * Data Access Object for Course entity : contains the logic for database
 * operation
 */

public class HibernateCourseDAO {

    // init a instance of session factory
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // instance of hibernate statistics showing with logSummary method
    Statistics             stats          = HibernateUtil.getSessionFactory().getStatistics();

    /**
     * CREATE an object Course in DataBase
     */
    public void createCourse( Course course ) {
        Session session = this.sessionFactory.openSession(); // open session
        Transaction tx = null; // init a transaction for this query
        try {
            tx = session.beginTransaction(); // start transaction
            session.persist( course ); // save the course
            // session.save( course );
            tx.commit(); // commit the transaction, execute flush process
        } catch ( HibernateException he ) {
            he.printStackTrace();
            if ( tx != null ) {
                try {
                    // cancel transaction if all query does not execute
                    tx.rollback();
                } catch ( HibernateException he2 ) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if ( session != null ) {
                try {
                    session.flush();
                    session.close(); // close session
                    stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }

        }
    }

    /**
     * GET LIST of all course object : return a set of object courses
     */
    // public Set<Course> getAllCourses() {
    public List<Course> getAllCourses() {

        Session session = this.sessionFactory.openSession();
        // Transaction tx = null;
        // HashSet<Course> courses = new HashSet<Course>();
        List<Course> coursesList = new ArrayList<Course>();
        try {
            // tx = session.beginTransaction();
            Query query = session.createQuery( "from Course" );
            // @SuppressWarnings( "unchecked" )
            // List<Course> coursesList = query.list(); // get resulset in List
            coursesList = query.list();
            // for ( Course c : coursesList ) { // copy the list in the set
            // courses.add( c );
            // }
            // tx.commit();
        } catch ( HibernateException he ) {
            he.printStackTrace();
            // if ( tx != null ) {
            // try {
            // tx.rollback();
            // } catch ( HibernateException he2 ) {
            // he2.printStackTrace();
            // }
            // }
        } finally {
            if ( session != null ) {
                try {
                    session.flush();
                    session.close();
                    stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }
        }
        // return courses;
        return coursesList;
    }

    /**
     * GET AN OBJECT COURSE by ID
     */
    public Course getCourseById( String CODE ) {
        Session session = this.sessionFactory.openSession();
        // Transaction tx = null;
        Course course = new Course();
        try {
            // tx = session.beginTransaction();
            String queryString = "FROM Course WHERE CODE = :CODE";
            Query query = session.createQuery( queryString );
            query.setParameter( "CODE", CODE );
            course = (Course) query.uniqueResult();
            // tx.commit();
        } catch ( HibernateException he ) {
            he.printStackTrace();
            // if ( tx != null ) {
            // try {
            // tx.rollback();
            // } catch ( HibernateException he2 ) {
            // he2.printStackTrace();
            // }
            // }
        } finally {
            if ( session != null ) {
                try {
                    session.flush();
                    session.close();
                    stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }
        }
        return course;
    }

    /**
     * UPDATE A COURSE
     */
    public void updateCourse( Course course ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge( course );
            tx.commit();
        } catch ( HibernateException he ) {
            he.printStackTrace();
            if ( tx != null ) {
                try {
                    tx.rollback();
                } catch ( HibernateException he2 ) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if ( session != null ) {
                try {
                    session.flush();
                    session.close();
                    stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }

        }
    }

    /**
     * DELETE A COURSE
     */
    public void deleteCourse( Course course ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete( course );
            // Rechercher puis supprimer un enregistrement
            // Course client = (Course) session.load(Course.class, new
            // String(code));
            // session.delete(client);
            tx.commit();
            session.flush();

        } catch ( HibernateException he ) {
            he.printStackTrace();
            if ( tx != null ) {
                try {
                    tx.rollback();
                } catch ( HibernateException he2 ) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if ( session != null ) {
                try {
                    session.flush();
                    session.close();
                    stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }

        }
    }
}
