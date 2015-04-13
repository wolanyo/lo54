package fr.utbm.lo54.coursesmanager.core.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;

public class HibernateCourseSessionDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Statistics             stats          = HibernateUtil.getSessionFactory().getStatistics();

    /**
     * GET LIST of a courseSession by course
     */
    public List<CourseSession> getCoursesSessionByCourse( String courseCode ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        List<CourseSession> coursesSessionList = new ArrayList<CourseSession>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery( "FROM CourseSession WHERE COURSE_CODE = :code" );
            query.setParameter( "code", courseCode );
            List<CourseSession> cl = query.list();
            // initialize proxy, this lazy collection
            for ( CourseSession cs : cl ) {
                Hibernate.initialize( cs.getCourse() );
                Hibernate.initialize( cs.getLocation() );
                coursesSessionList.add( cs );
            }
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
                    session.close();
                    stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }
        }
        return coursesSessionList;

    }

    /**
     * GET LIST of all courseSession object
     */
    public List<CourseSession> getAllCoursesSession() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        List<CourseSession> coursesSessionList = new ArrayList<CourseSession>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery( "from CourseSession" );
            List<CourseSession> cl = query.list();
            // coursesSessionList = query.list();
            // initialize proxy, this lazy collection
            for ( CourseSession cs : cl ) {
                Hibernate.initialize( cs.getCourse() );
                Hibernate.initialize( cs.getLocation() );
                coursesSessionList.add( cs );
            }

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
                    session.close();
                    stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }
        }
        return coursesSessionList;
    }

    /**
     * GET AN OBJECT COURSESESSION by ID
     */
    public CourseSession getCourseSessionById( long id ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        CourseSession courseSession = new CourseSession();
        try {
            tx = session.beginTransaction();
            String queryString = "FROM CourseSession WHERE id = :id";
            Query query = session.createQuery( queryString );
            query.setParameter( "id", id );
            courseSession = (CourseSession) query.uniqueResult();
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
                    session.close();
                    // stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }
        }
        return courseSession;
    }

    /**
     * CREATE an object CourseSession SESSION in DataBase
     */
    public void createCourseSession( CourseSession courseSession ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist( courseSession );
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
                    session.close();
                    // stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }

        }
    }

    /**
     * UPDATE A CourseSession
     */
    public void updateCourseSession( CourseSession courseSession ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge( courseSession );
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
                    session.close();
                    // stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }

        }
    }

    /**
     * DELETE A CourseSession
     */
    public void deleteCourseSession( CourseSession courseSession ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete( courseSession );
            // Rechercher puis supprimer un enregistrement
            // CourseSession client = (CourseSession)
            // session.load(CourseSession.class, new
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
                    // stats.logSummary();
                } catch ( HibernateException he ) {
                    he.printStackTrace();
                }
            }
        }
    }
}
