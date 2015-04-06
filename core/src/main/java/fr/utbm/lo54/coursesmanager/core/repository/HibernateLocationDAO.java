package fr.utbm.lo54.coursesmanager.core.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.utbm.lo54.coursesmanager.core.entity.Location;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;

public class HibernateLocationDAO {
    private SessionFactory sessionFactory;

    public HibernateLocationDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public HibernateLocationDAO( SessionFactory ses ) {
        this.sessionFactory = ses;
    }

    /**
     * GET LIST OF LOCATION
     * 
     * @return
     */
    public Set<Location> getList() {
        Session session = this.sessionFactory.openSession();
        HashSet<Location> locations = new HashSet<Location>();
        try {
            Query q = session.createQuery( "FROM Location" );
            @SuppressWarnings( "unchecked" )
            List<Location> l = q.list();
            for ( Location s : l ) {
                locations.add( s );
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
        return locations;
    }

    /**
     * 
     * GET LOCATION BY ID
     * 
     * @param id
     * @return
     */
    public Location getById( Long id ) {
        Session session = this.sessionFactory.openSession();
        Location location = new Location();
        try {
            Query q = session.createQuery( "FROM Location WHERE id = :id" );
            q.setParameter( "id", id );
            location = (Location) q.uniqueResult();
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
        return location;
    }

    /**
     * SAVE A LOCATION
     * 
     * @param loc
     * @return
     */
    public Location save( Location loc ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save( loc );
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
        return loc;
    }

    /**
     * UPDATE A LOCATION
     * 
     * @param loc
     * @return
     */
    public Location update( Location loc ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge( loc );
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
        return loc;
    }

    /**
     * DELETE A LOCATION
     * 
     * @param loc
     * @return
     */
    public Location delete( Location loc ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete( loc );
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
        loc.setId( null );
        return loc;
    }

}
