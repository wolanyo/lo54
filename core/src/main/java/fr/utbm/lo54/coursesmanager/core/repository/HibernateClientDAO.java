package fr.utbm.lo54.coursesmanager.core.repository;

import fr.utbm.lo54.coursesmanager.core.repository.Interface.InterfaceDAO;
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
import java.util.HashSet;
import java.util.Set;

public class HibernateClientDAO implements InterfaceDAO <Client,Long>{

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Statistics stats = HibernateUtil.getSessionFactory().getStatistics();

    /**
     * CREATE an object Client SESSION in DataBase
     */
    public void create(Client client) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            // session.save( client );
            session.merge(client);
            // session.persist( client );
            tx.commit();
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
                    stats.logSummary();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }

        }
    }

    /**
     * GET LIST of all client object
     */
    public Set<Client> getList() {
        Session session = this.sessionFactory.openSession();
		HashSet<Client> clients = new HashSet<Client>();
		try {
			Query q = session.createQuery("FROM Client");
			@SuppressWarnings("unchecked")
			List<Client> u = q.list();
			for (Client s : u) {
				u.add(s);
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
		return clients;
        }

    /**
     * GET AN OBJECT Client by ID
     */
	public Client getById(Long id) {
		return getById(id, false, false, false);
	}
        
	public Client getById(Long id, Boolean sessions, Boolean course, Boolean location) {
		Session session = this.sessionFactory.openSession();
		Client client = new Client();
		try {
			Query q = session.createQuery("FROM User WHERE id = :id");
			q.setParameter("id",id);
			client = (Client) q.list().get(0);
			if (sessions) {
				Hibernate.initialize(client.getCoursesessions());
			}
			if (course) {
				Hibernate.initialize(client.getCoursesessions().iterator().next().getCourse());
			}
			if (location) {
				Hibernate.initialize(client.getCoursesessions().iterator().next().getLocation());
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
		
		return client;
	}

    /**
     * UPDATE A Client
     */
    public void update(Client client) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(client);
            tx.commit();
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
     * DELETE A Client
     * @param client
     */
    public void delete(Client client) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(client);
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
