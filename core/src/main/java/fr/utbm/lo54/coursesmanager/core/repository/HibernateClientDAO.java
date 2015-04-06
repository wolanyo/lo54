package fr.utbm.lo54.coursesmanager.core.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.utbm.lo54.coursesmanager.core.entity.Client;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;

public class HibernateClientDAO {

    private SessionFactory sessionFactory;

    public HibernateClientDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public HibernateClientDAO( SessionFactory ses ) {
        this.sessionFactory = ses;
    }

    /**
     * GET LIST OF USER
     * 
     * @return
     */
    public Set<Client> getList() {
        Session session = this.sessionFactory.openSession();
        HashSet<Client> clients = new HashSet<Client>();
        try {
            Query q = session.createQuery( "FROM Client" );
            @SuppressWarnings( "unchecked" )
            List<Client> clt = q.list();
            for ( Client s : clt ) {
                clt.add( s );
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
        return clients;
    }

    /**
     * 
     * @param id
     * @return
     */
    public Client getById( Long id ) {
        return getById( id, false, false, false );
    }

    public Client getById( Long id, Boolean sessionFactory, Boolean course, Boolean location ) {
        Session session = this.sessionFactory.openSession();
        Client client = new Client();
        // try {
        // Query q = session.createQuery( "FROM Client WHERE id = :id" );
        // q.setParameter( "id", id );
        // client = (Client) q.list().get( 0 );
        // if ( sessionFactory ) {
        // Hibernate.initialize( client.getCoursesessions() );
        // }
        // if ( course ) {
        // Hibernate.initialize(
        // client.getCoursesessions().iterator().next().getCourse() );
        // }
        // if ( location ) {
        // Hibernate.initialize(
        // client.getCoursesessions().iterator().next().getLocation() );
        // }
        // } catch ( HibernateException e ) {
        // e.printStackTrace();
        // } finally {
        // if ( session != null ) {
        // try {
        // session.close();
        // } catch ( HibernateException f ) {
        // f.printStackTrace();
        // }
        // }
        // }

        return client;
    }

    public Client create( Client client ) {
        Session session = this.sessionFactory.openSession();
        Transaction transact = null;
        try {
            transact = session.beginTransaction();
            session.save( client );
            transact.commit();
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
        return client;
    }

    public Client update( Client client ) {
        Session session = this.sessionFactory.openSession();
        Transaction transact = null;
        try {
            transact = session.beginTransaction();
            session.merge( client );
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
        return client;
    }

    public Client delete( Client client ) {
        Session session = this.sessionFactory.openSession();
        Transaction transact = null;
        try {
            transact = session.beginTransaction();
            session.delete( client );
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
        client.setId( null );
        return client;
    }
}
