package ru.eltex.app.java.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.eltex.app.java.hibernate.HibernateSessionFactoryUtil;
import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.shop.Credentials;
import ru.eltex.app.java.model.shop.Order;
import ru.eltex.app.java.model.shop.ShoppingCart;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class DAOImpl implements DAO {
    @PersistenceContext
    @Override
    public Devices findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Devices devices = session.get(Devices.class, id);
        session.close();
        return devices;
    }

    @Override
    public void saveDevice(Devices devices) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = (Transaction) session.beginTransaction();
        session.save(devices);
        tx1.commit();
        session.close();
    }

    @Override
    public void saveCredentials(Credentials credentials) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = (Transaction) session.beginTransaction();
        session.save(credentials);
        tx1.commit();
        session.close();
    }

    @Transactional
    @Override
    public void saveShoppingCard(ShoppingCart shoppingCart) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = (Transaction) session.beginTransaction();
        session.save(shoppingCart);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateDevice(Devices devices) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(devices);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteDevice(Devices devices) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(devices);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteOrder(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(order);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteOrder(int id) {
        Order myObject;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        myObject = (Order) session.load(Order.class, id);
        session.delete(myObject);
        session.close();
    }
    @Override
    public Devices findDeviceById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Devices devices = session.get(Devices.class, id);
        session.close();
        return devices;
    }

    @Override
    public Order findOrderById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }
    @Override
    public Devices findDeviceByUUID(UUID id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Devices devices = session.get(Devices.class, id);
        session.close();
        return devices;
    }

    @Override
    public List<Devices> findAll() {
        return null;
    }

    @Override
    public List<Order> findAllOrder() {
        return (List<Order>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Order").list();
    }

    public void saveOrder(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = (Transaction) session.beginTransaction();
        session.save(order);
        tx1.commit();
        session.close();
    }
}
