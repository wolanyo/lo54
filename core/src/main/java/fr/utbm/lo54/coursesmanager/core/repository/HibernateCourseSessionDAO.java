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

import fr.utbm.lo54.coursesmanager.core.entity.CourseSession;
import fr.utbm.lo54.coursesmanager.core.util.HibernateUtil;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class HibernateCourseSessionDAO implements InterfaceDAO<CourseSession, Long> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Statistics stats = HibernateUtil.getSessionFactory().getStatistics();

    /**
     * GET LIST of a courseSession by course
     */
    public List<CourseSession> getCoursesSessionByCourse(String courseCode) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        List<CourseSession> coursesSessionList = new ArrayList<CourseSession>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM CourseSession WHERE COURSE_CODE = :code");
            query.setParameter("code", courseCode);
            List<CourseSession> cl = query.list();
            // initialize proxy, this lazy collection
            for (CourseSession cs : cl) {
                Hibernate.initialize(cs.getCourse());
                Hibernate.initialize(cs.getLocation());
                coursesSessionList.add(cs);
            }
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
                    stats.logSummary();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }
        }
        return coursesSessionList;

    }

    /**
     * GET LIST of all courseSession object
     */
    public Set<CourseSession> getList() {
        Session session = this.sessionFactory.openSession();
        HashSet<CourseSession> coursesSessionList = new HashSet<CourseSession>();
        try {
            Query query = session.createQuery("from CourseSession");
            List<CourseSession> cl = query.list();
            // coursesSessionList = query.list();
            // initialize proxy, this lazy collection
            for (CourseSession cs : cl) {
                Hibernate.initialize(cs.getCourse());
                Hibernate.initialize(cs.getLocation());
                coursesSessionList.add(cs);
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
        return coursesSessionList;
    }

    /**
     * GET AN OBJECT COURSESESSION by ID
     */
    public CourseSession getById(Long id) {
        return this.getById(id, false, false);
    }

    public CourseSession getById(Long id, Boolean loadCourse, Boolean loadLocation) {
        Session session = this.sessionFactory.openSession();
        CourseSession course_session = new CourseSession();
        try {
            Query q = session.createQuery("FROM CourseSession WHERE id = :id");
            q.setParameter("id", id);
            course_session = (CourseSession) q.uniqueResult();
            if (loadCourse) {
                Hibernate.initialize(course_session.getCourse());
            }
            if (loadLocation) {
                Hibernate.initialize(course_session.getLocation());
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
        return course_session;
    }

    /**
     * CREATE an object CourseSession SESSION in DataBase
     */
    public void create(CourseSession courseSession) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(courseSession);
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
     * UPDATE A CourseSession
     */
    public void update(CourseSession courseSession) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(courseSession);
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
     * DELETE A CourseSession
     */
    public void delete(CourseSession courseSession) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(courseSession);
            // Rechercher puis supprimer un enregistrement
            // CourseSession client = (CourseSession)
            // session.load(CourseSession.class, new
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
                    session.flush();
                    session.close();
                    // stats.logSummary();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<CourseSession> filterByStartDate(Date startDate) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria= session.createCriteria(CourseSession.class);
		List<CourseSession> course_sessions = new ArrayList<CourseSession>();
		try {
			criteria.add(Restrictions.eq("startDate",startDate));
			course_sessions = criteria.list();
			for (CourseSession courseSession : course_sessions) {
				Hibernate.initialize(courseSession.getCourse());
				Hibernate.initialize(courseSession.getLocation());
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
	@SuppressWarnings("unchecked")
	public List<CourseSession> filterByEndDate(Date endDate) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria= session.createCriteria(CourseSession.class);
		List<CourseSession> course_sessions = new ArrayList<CourseSession>();
		try {
			criteria.add(Restrictions.eq("endDate",endDate));
			course_sessions = criteria.list();
			for (CourseSession courseSession : course_sessions) {
				Hibernate.initialize(courseSession.getCourse());
				Hibernate.initialize(courseSession.getLocation());
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
	@SuppressWarnings("unchecked")
	public List<CourseSession> filterByDates(Date startDate, Date endDate) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria= session.createCriteria(CourseSession.class);
		List<CourseSession> course_sessions = new ArrayList<CourseSession>();
		try {
			criteria.add(Restrictions.conjunction()
					.add(Restrictions.ge("startDate", startDate))
					.add(Restrictions.le("endDate", endDate)));
			course_sessions = criteria.list();
			for (CourseSession courseSession : course_sessions) {
				Hibernate.initialize(courseSession.getCourse());
				Hibernate.initialize(courseSession.getLocation());
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
