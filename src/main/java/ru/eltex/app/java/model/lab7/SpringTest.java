package ru.eltex.app.java.model.lab7;


import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.eltex.app.java.controller.WebController;
import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.shop.ManagerOrderFile;
import ru.eltex.app.java.model.shop.ManagerOrderJSON;

import java.io.IOException;
import java.util.LinkedList;


class Application {

    private static LinkedList<Devices> DevicesArray = null;
    private static ManagerOrderFile managerOrderFile;
    private static ManagerOrderJSON managerOrderJSON;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext(WebController.class);
        ManagerOrderFile managerOrderFile = context.getBean("managerOrderFile", ManagerOrderFile.class);
        BeanWrapper beanWrapper = new BeanWrapperImpl(managerOrderFile);


    }


}
