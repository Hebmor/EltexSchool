package ru.eltex.app.java.hibernate;

import org.springframework.stereotype.Service;
import ru.eltex.app.java.dao.DAOImpl;
import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.shop.Credentials;
import ru.eltex.app.java.model.shop.Order;
import ru.eltex.app.java.model.shop.ShoppingCart;
import ru.eltex.app.java.model.shop.SimpleException;

import java.util.List;

@Service
public class DevicesService {
    private DAOImpl dao = new DAOImpl();

    public DevicesService() {
    }

    public Devices findUser(int id) {
        return dao.findDeviceById(id);
    }

    public void saveDevice(Devices devices) {
        dao.saveDevice(devices);
    }
    public void saveCredentials(Credentials credentials) {
        dao.saveCredentials(credentials);
    }
    public void saveShoppingCard(ShoppingCart shoppingCart) {
        dao.saveShoppingCard(shoppingCart);
    }

    public void saveOrder(Order order) {
        dao.saveOrder(order);
    }
    public void deleteUser(Devices devices) {
        dao.deleteDevice(devices);
    }

    public void updateUser(Devices devices) {
        dao.updateDevice(devices);
    }

    public List<Devices> findAllUsers() {
        return dao.findAll();
    }

    public List<Order> findAllOrder() {
        return dao.findAllOrder();
    }

    public Devices findDeviceById(int id) {
        return dao.findDeviceById(id);
    }

    public Order findOrderById(int id) {
        return dao.findOrderById(id);
    }

    public boolean deleteDevice(int id) throws SimpleException {
        Order order = dao.findOrderById(id);
        if (order != null) {
            dao.deleteOrder(order);
            return true;
        } else
            throw new SimpleException("Нет такого заказа!", 1);
    }

}
