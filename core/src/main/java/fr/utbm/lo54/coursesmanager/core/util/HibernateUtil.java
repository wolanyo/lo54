package fr.utbm.lo54.coursesmanager.core.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * allows to call a Hibernate Session Factory easily
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // initialise hibernate : Create the SessionFactory from
            // hibernate.cfg.xml config file
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch ( Throwable ex ) {
            // Log the exception.
            System.err.println( "Initial SessionFactory creation failed." + ex );
            throw new ExceptionInInitializerError( ex );
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
