package ru.eltex.app.java.lab5;


import ru.eltex.app.java.products.Devices;
import ru.eltex.app.java.products.Phones;
import ru.eltex.app.java.products.Smartphones;
import ru.eltex.app.java.products.Tablets;
import ru.eltex.app.java.shop.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

    private static LinkedList<Devices> DevicesArray = null;
    private static ManagerOrderFile managerOrderFile;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Orders<Devices> write_orders = new Orders<Devices>();
        Orders<Devices> read_orders = new Orders<Devices>();
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

    public static void TestWrite(Orders write_orders) throws IOException, InterruptedException {

        managerOrderFile = new ManagerOrderFile("resource/binary_date/date.dat", write_orders);

        //Гонка потоков
        GeneratorOrders generatorOrders = new GeneratorOrders("gen1", write_orders, 2000, 6, 5, false, false);
        GeneratorOrders generatorOrders2 = new GeneratorOrders("gen2", write_orders, 4000, 8, 4, false, false);

        generatorOrders.start();
        generatorOrders2.start();

        generatorOrders.Join();
        generatorOrders2.Join();
        managerOrderFile.saveAll();
        //write_orders.showAllOrders();

    }

    public static void TestRead(Orders read_orders) throws IOException, ClassNotFoundException {
        read_orders.add(managerOrderFile.readByID(2));
        read_orders.add(managerOrderFile.readByID(1));
        read_orders.showAllOrders();
    }

}
