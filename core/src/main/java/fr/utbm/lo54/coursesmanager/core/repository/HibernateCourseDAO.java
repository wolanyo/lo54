package fr.utbm.lo54.coursesmanager.core.repository;

import fr.utbm.lo54.coursesmanager.core.repository.Interface.InterfaceDAO;
import fr.utbm.lo54.coursesmanager.core.entity.Client;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import fr.utbm.lo54.coursesmanager.core.entity.Course;
import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;

/**
 * Data Access Object for Course entity : contains the logic for database
 * operation
 */
public class HibernateCourseDAO implements InterfaceDAO<Course, String> {

    // init a instance of session factory
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // instance of hibernate statistics showing with logSummary method
    Statistics stats = HibernateUtil.getSessionFactory().getStatistics();

    /**
     * CREATE an object Course in DataBase
     */
    public void create(Course course) {
        Session session = this.sessionFactory.openSession(); // open session
        Transaction tx = null; // init a transaction for this query
        try {
            tx = session.beginTransaction(); // start transaction
            session.persist(course); // save the course
            // session.save( course );
            tx.commit(); // commit the transaction, execute flush process
            session.flush();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (tx != null) {
                try {
                    // cancel transaction if all query does not execute
                    tx.rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close(); // close session
                    stats.logSummary();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }

        }
    }

    /**
     * GET LIST of all course object : return a set of object courses
     */
    public Set<Course> getList() {

        Session session = this.sessionFactory.openSession();
        HashSet<Course> courses = new HashSet<Course>();
        try {
            Query q = session.createQuery("from Course");
            @SuppressWarnings("unchecked")
            List<Course> l = q.list();
            for (Course c : l) {
                courses.add(c);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException f) {
                    f.printStackTrace();
                }
            }
        }
        return courses;
    }

    @SuppressWarnings("unchecked")
    public List<CourseSession> filterByKeyword(List<String> keywords) {
        Session session = this.sessionFactory.openSession();
        List<CourseSession> course_sessions = new ArrayList<CourseSession>();
        try {
            Query q = session.createQuery("FROM CourseSession WHERE course.title in (:keys)");
            q.setParameterList("keys", keywords);
            course_sessions = q.list();
            for (CourseSession cs : course_sessions) {
                Hibernate.initialize(cs.getCourse());
                Hibernate.initialize(cs.getLocation());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException f) {
                    f.printStackTrace();
                }
            }
        }
        return course_sessions;
    }

    /**
     * GET AN OBJECT COURSE by ID
     */
    public Course getById(String CODE) {
        Session session = this.sessionFactory.openSession();
        Course course = new Course();
        try {
            String queryString = "FROM Course WHERE CODE = :CODE";
            Query query = session.createQuery(queryString);
            query.setParameter("CODE", CODE);
            course = (Course) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException f) {
                    f.printStackTrace();
                }
            }
        }
        return course;
    }

    /**
     * UPDATE A COURSE
     */
    public void update(Course course) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(course);
            tx.commit();
            session.flush();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                    // stats.logSummary();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }

        }
    }

    /**
     * DELETE A COURSE
     */
    public void delete(Course course) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(course);
            // Rechercher puis supprimer un enregistrement
            // Course client = (Course) session.load(Course.class, new
            // String(code));
            // session.delete(client);
            tx.commit();
            session.flush();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                    // stats.logSummary();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }

        }
    }

}
