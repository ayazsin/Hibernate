package project03_oneToMany.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import project02_JPA.exception.HbException;

public class HibernateTools {

    private static SessionFactory sessionFactory = null;

    // static method
    public static SessionFactory getSessionFactory() throws HbException {
        startHb();
        return sessionFactory;
    }

    private static void startHb() throws HbException {
        if (sessionFactory == null) { //do it once!
            try{
                StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
                sessionFactory = meta.getSessionFactoryBuilder().build();
            } catch (Throwable ex) {
                System.err.println("Session Factory could not be created." + ex);
                throw new HbException("Session Factory could not be created." + ex);
            }

        }
    }
}
