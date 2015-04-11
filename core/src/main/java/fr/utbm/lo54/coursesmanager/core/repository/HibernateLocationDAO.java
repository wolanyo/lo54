package fr.utbm.lo54.coursesmanager.core.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import fr.utbm.lo54.coursesmanager.core.entity.Location;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;

public class HibernateLocationDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Statistics             stats          = HibernateUtil.getSessionFactory().getStatistics();

    /**
     * GET LIST of all location object
     */
    public List<Location> getAllLocations() {
        Session session = this.sessionFactory.openSession();
        // Transaction tx = null;
        List<Location> locationList = new ArrayList<Location>();
        try {
            // tx = session.beginTransaction();
            Query query = session.createQuery( "FROM Location" );
            locationList = query.list();
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
        return locationList;
    }

    /**
     * GET AN OBJECT Location by ID
     */
    public Location getLocationById( long id ) {
        Session session = this.sessionFactory.openSession();
        // Transaction tx = null;
        Location location = new Location();
        try {
            // tx = session.beginTransaction();
            String queryString = "FROM Location WHERE id = :id";
            Query query = session.createQuery( queryString );
            query.setParameter( "id", id );
            location = (Location) query.uniqueResult();
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
        return location;
    }

    /**
     * CREATE an object Location in DataBase
     */
    public void createLocation( Location location ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist( location );
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
     * UPDATE A Location
     */
    public void updateLocation( Location location ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge( location );
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
     * DELETE A Location
     */
    public void deleteLocation( Location location ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete( location );
            // Rechercher puis supprimer un enregistrement
            // Location client = (Location)
            // session.load(Location.class, new
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
