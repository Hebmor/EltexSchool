package ru.eltex.app.java.hibernate;

import ru.eltex.app.java.dao.DAOImpl;
import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.shop.Credentials;
import ru.eltex.app.java.model.shop.Order;
import ru.eltex.app.java.model.shop.ShoppingCart;

import java.util.List;

public class DevicesService {
    private DAOImpl dao = new DAOImpl();

    public DevicesService() {
    }

    public Devices findUser(int id) {
        return dao.findDeviceById(id);
    }

    public void saveDevice(Devices devices) {
        dao.save(devices);
    }
    public void saveCredentials(Credentials credentials) {
        dao.save(credentials);
    }
    public void saveShoppingCard(ShoppingCart shoppingCart) {
        dao.save(shoppingCart);
    }

    public void saveOrder(Order order) {
        dao.save(order);
    }
    public void deleteUser(Devices devices) {
        dao.delete(devices);
    }

    public void updateUser(Devices devices) {
        dao.update(devices);
    }

    public List<Devices> findAllUsers() {
        return dao.findAll();
    }

//    public Devices findAutoById(int id) {
//        return dao.findAutoById(id);
//    }

}
