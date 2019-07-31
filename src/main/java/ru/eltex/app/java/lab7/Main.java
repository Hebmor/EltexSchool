package ru.eltex.app.java.lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.eltex.app.java.products.Devices;
import ru.eltex.app.java.shop.ManagerOrderFile;
import ru.eltex.app.java.shop.ManagerOrderJSON;

import java.io.IOException;
import java.util.LinkedList;

@SpringBootApplication
class Application {

    private static LinkedList<Devices> DevicesArray = null;
    private static ManagerOrderFile managerOrderFile;
    private static ManagerOrderJSON managerOrderJSON;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        SpringApplication.run(Application.class, args);

    }


}
