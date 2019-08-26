package ru.eltex.app.java.dao;

import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.shop.Credentials;
import ru.eltex.app.java.model.shop.Order;
import ru.eltex.app.java.model.shop.ShoppingCart;

import java.util.List;
import java.util.UUID;

public interface DAO {
    Devices findById(int id);

    void saveDevice(Devices devices);

    void saveCredentials(Credentials devices);

    void saveShoppingCard(ShoppingCart devices);

    void saveOrder(Order order);

    void updateDevice(Devices devices);

    void deleteDevice(Devices devices);

    Devices findDeviceById(int id);

    Order findOrderById(int id);
    Devices findDeviceByUUID(UUID id);

    void deleteOrder(Order order);

    void deleteOrder(int id);
    List<Devices> findAll();

    List<Order> findAllOrder();
}
