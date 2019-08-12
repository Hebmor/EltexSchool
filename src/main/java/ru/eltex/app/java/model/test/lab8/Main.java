package ru.eltex.app.java.model.test.lab8;

import ru.eltex.app.java.hibernate.DevicesService;
import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.products.Phones;
import ru.eltex.app.java.model.products.Smartphones;
import ru.eltex.app.java.model.shop.Credentials;
import ru.eltex.app.java.model.shop.ShoppingCart;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        TestHibernate();
    }
    public static void TestHibernate() {
        DevicesService devicesService = new DevicesService();
        Smartphones phones = new Smartphones();
        phones.create();
        Phones phones2 = new Phones();
        phones2.create();
        Credentials credentials2 = new Credentials("e","e","e","e");
        // devicesService.saveDevice(phones);
       // devicesService.saveDevice(phones2);
      //  devicesService.saveCredentials(credentials);
        ShoppingCart<Devices> shoppingCart = new ShoppingCart(credentials2, phones2);
        devicesService.saveShoppingCard(shoppingCart);
//        devicesService.findAllUsers();


    }

}
