package ru.eltex.app.java.model.test.lab8;

import ru.eltex.app.java.hibernate.DevicesService;
import ru.eltex.app.java.model.products.Phones;
import ru.eltex.app.java.model.products.Smartphones;

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
        devicesService.saveUser(phones);
        devicesService.saveUser(phones2);
//        devicesService.findAllUsers();


    }

}
