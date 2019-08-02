package ru.eltex.app.java.model.lab5;


import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.products.Phones;
import ru.eltex.app.java.model.products.Smartphones;
import ru.eltex.app.java.model.products.Tablets;
import ru.eltex.app.java.model.shop.*;

import java.io.IOException;
import java.util.LinkedList;

public class Main {

    private static LinkedList<Devices> DevicesArray = null;
    private static ManagerOrderFile managerOrderFile;
    private static ManagerOrderJSON managerOrderJSON;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Orders<Order> write_orders = new Orders<>();
        Orders<Order> read_orders = new Orders<>();
        TestWrite(write_orders);
        TestRead(read_orders);

    }

    public static void GenerateInput(String[] _args) {
        int countObject = 0;
        int counter = 0;
        String typeObject;
        if (_args.length != 2) {
            System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
            System.out.println("java code.java {количество вводимых объектов} {вид представления}");
            return;
        }
        countObject = Integer.parseInt(_args[0]);
        typeObject = _args[1];
        DevicesArray = new LinkedList<Devices>();

        switch (typeObject) {
            case "Phones": {

                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Phones());
                    ((Phones) DevicesArray.get(i)).create();
                }
                break;
            }
            case "Smartphones": {
                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Smartphones());
                    ((Smartphones) DevicesArray.get(i)).create();
                }
                break;
            }
            case "Tablets": {
                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Tablets());
                    ((Tablets) DevicesArray.get(i)).create();
                }
                break;
            }
            default: {
                System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
                System.out.println("java code.java {количество вводимых объектов} {phones/smartphones/tablets}");
            }

        }
    }

    public static void TestWrite(Orders write_orders) throws IOException, InterruptedException, ClassNotFoundException {

        managerOrderFile = new ManagerOrderFile("resources/binary_date/data.dat", write_orders);
        managerOrderJSON = new ManagerOrderJSON("resources/json/json_data.json", write_orders);

        //Гонка потоков
        GeneratorOrders generatorOrders = new GeneratorOrders("gen1", write_orders, 0, 3, 2, false, false);
        GeneratorOrders generatorOrders2 = new GeneratorOrders("gen2", write_orders, 0, 3, 2, false, false);

        generatorOrders.start();
        generatorOrders2.start();

        generatorOrders.Join();
        generatorOrders2.Join();
        managerOrderFile.saveAll();
        managerOrderJSON.saveById(1);
        managerOrderJSON.saveById(0);
        managerOrderJSON.saveById(2);
        //write_orders.showAllOrders();

    }

    public static void TestRead(Orders read_orders) throws IOException, ClassNotFoundException {

        Orders binaryRead = new Orders();
        Orders jsonRead = new Orders();
        System.out.println("BINARY FILE");
        binaryRead.setOrdersArrayList(managerOrderFile.readAll());
        binaryRead.showAllOrders();
        System.out.println("JSON FILE");
        jsonRead.add(managerOrderJSON.readByID(0));
        jsonRead.add(managerOrderJSON.readByID(2));
        //jsonRead.add( managerOrderJSON.readByID(3));
        jsonRead.showAllOrders();
    }

}
