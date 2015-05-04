package fr.utbm.lo54.coursesmanager.core.repository;

import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;
import fr.utbm.lo54.coursesmanager.core.repository.Interface.InterfaceDAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.utbm.lo54.coursesmanager.core.entity.Location;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;

public class HibernateLocationDAO implements InterfaceDAO<Location, Long> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // Statistics stats = HibernateUtil.getSessionFactory().getStatistics();
    /**
     * GET LIST of all location object
     */
    public Set<Location> getList() {
        Session session = this.sessionFactory.openSession();
        HashSet<Location> locationList = new HashSet<Location>();
        try {
            Query query = session.createQuery("FROM Location");
            List<Location> l = query.list();
            for (Location c : l) {
                locationList.add(c);
            }
            }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException f) {
                    f.printStackTrace();
                }
            }
        }
            return locationList;
        }
        /**
         * GET AN OBJECT update by ID
         */
    public Location getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Location location = new Location();
        try {
            String queryString = "FROM Location WHERE id = :id";
            Query query = session.createQuery(queryString);
            query.setParameter("id", id);
            location = (Location) query.uniqueResult();
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
        return location;
    }

    /**
     * CREATE an object update in DataBase
     */
    public void create(Location location) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(location);
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
     * UPDATE A update
     */
    public void update(Location location) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(location);
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
     * DELETE A update
     */
    public void delete(Location location) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(location);
            // Rechercher puis supprimer un enregistrement
            // update client = (update)
            // session.load(update.class, new
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

    @SuppressWarnings("unchecked")
    public List<CourseSession> filterByLocation(List<Location> ids) {
        Session session = this.sessionFactory.openSession();
        List<CourseSession> course_sessions = new ArrayList<CourseSession>();
        try {
            Query q = session.createQuery("FROM CourseSession WHERE location IN (:location)");
            q.setParameterList("location", ids);
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

}
