package ru.eltex.app.java.lab7;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        ManagerOrderFile managerOrderFile = context.getBean("ManagerOrderFile", ManagerOrderFile.class);

        context.close();

    }


}
