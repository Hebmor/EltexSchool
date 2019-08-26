package ru.eltex.app.java.model.test.lab8;

import ru.eltex.app.java.hibernate.DevicesService;
import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.products.Phones;
import ru.eltex.app.java.model.products.Smartphones;
import ru.eltex.app.java.model.products.Tablets;
import ru.eltex.app.java.model.shop.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestHibernate();
    }

    private static void TestHibernate() throws InterruptedException {
        DevicesService devicesService = new DevicesService();
        Smartphones phones = new Smartphones();
        phones.create();
        Devices phones2 = new Phones();
        phones2.create();
        Devices phones3 = new Tablets();
        phones3.create();
        Credentials credentials = new Credentials("tr", "rt", "rt", "rtt");
        Credentials credentials2 = new Credentials("e","e","e","e");
        Orders write_orders = new Orders();
        GeneratorOrders generatorOrders = new GeneratorOrders("gen1", write_orders, 0, 3, 4, false, false);

        ShoppingCart<Devices> shoppingCart = new ShoppingCart(credentials2, phones);
        ShoppingCart<Devices> shoppingCart2 = new ShoppingCart(credentials, phones);
        shoppingCart.add(phones2);
        shoppingCart2.add(phones3);
        generatorOrders.start();

        generatorOrders.Join();
        devicesService.saveOrder(write_orders.get(1));
        devicesService.saveOrder(write_orders.get(0));
        ArrayList<Order> arrayList = (ArrayList<Order>) devicesService.findAllOrder();

    }

}
