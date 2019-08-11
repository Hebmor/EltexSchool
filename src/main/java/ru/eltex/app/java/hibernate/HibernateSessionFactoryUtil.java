package ru.eltex.app.java.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;


    private HibernateSessionFactoryUtil() {
    }


    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();

        } catch (HibernateException he) {
            System.out.println("Session Factory creation failure");
            throw he;
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
//                Configuration configuration = new Configuration().configure();
//                configuration.addAnnotatedClass(Devices.class);
//                configuration.addAnnotatedClass(Phones.class);
//                configuration.addAnnotatedClass(Smartphones.class);
//                configuration.addAnnotatedClass(Tablets.class);
//                configuration.addResource("devices.hbm.xml");
//                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//                sessionFactory = configuration.buildSessionFactory(builder.build());
                sessionFactory = buildSessionFactory();

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
