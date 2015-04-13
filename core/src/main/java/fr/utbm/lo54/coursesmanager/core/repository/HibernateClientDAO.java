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

import fr.utbm.lo54.coursesmanager.core.entity.Client;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;

public class HibernateClientDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Statistics             stats          = HibernateUtil.getSessionFactory().getStatistics();

    /**
     * CREATE an object Client SESSION in DataBase
     */
    public void createClient( Client client ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save( client );
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
    }

    /**
     * GET LIST of all client object
     */
    public List<Client> getAllClient() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        List<Client> clientList = new ArrayList<Client>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery( "from Client" );
            List<Client> cl = query.list();
            // clientList = query.list();
            // initialize proxy, this lazy collection
            for ( Client cs : cl ) {
                Hibernate.initialize( cs.getCoursesession() );
                clientList.add( cs );
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
        return clientList;
    }

    /**
     * GET AN OBJECT COURSESESSION by ID
     */
    public Client getClientById( long id ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        Client client = new Client();
        try {
            tx = session.beginTransaction();
            String queryString = "FROM Client WHERE id = :id";
            Query query = session.createQuery( queryString );
            query.setParameter( "id", id );
            client = (Client) query.uniqueResult();
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
        return client;
    }

    /**
     * UPDATE A Client
     */
    public void updateClient( Client client ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge( client );
            tx.commit();
            // session.flush();
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
    }

    /**
     * DELETE A Client
     */
    public void deleteClient( Client client ) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete( client );
            // Rechercher puis supprimer un enregistrement
            // Client client = (Client)
            // session.load(Client.class, new
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
