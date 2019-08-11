package ru.eltex.app.java.dao;

import org.hibernate.Session;
import ru.eltex.app.java.hibernate.HibernateSessionFactoryUtil;
import ru.eltex.app.java.model.products.Devices;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class DAOImpl implements DAO {
    @Override
    public Devices findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Devices.class, id);
    }

    @Override
    public void save(Devices devices) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = (Transaction) session.beginTransaction();
        session.save(devices);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Devices devices) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(devices);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Devices devices) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(devices);
        tx1.commit();
        session.close();
    }

    @Override
    public Devices findDeviceById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Devices.class, id);
    }

    @Override
    public Devices findDeviceByUUID(UUID id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Devices.class, id);
    }

    @Override
    public List<Devices> findAll() {
        return null;
    }
//    @Override
//    public List<Devices> findAll() {
//        List<Devices> users = (List<Devices>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM").list();
//        return users;
//    }
}
