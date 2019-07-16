package ru.eltex.app.java.lab4;


import ru.eltex.app.java.products.Devices;
import ru.eltex.app.java.products.Phones;
import ru.eltex.app.java.products.Smartphones;
import ru.eltex.app.java.products.Tablets;
import ru.eltex.app.java.shop.*;

import java.util.LinkedList;

public class Main {

    private static LinkedList<Devices> DevicesArray = null;

    public static void main(String[] args) {

        Orders<Devices> orders = new Orders<Devices>();
        TestThread(orders);

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

    public static void TestThread(Orders orders) {
        PendingCheck pendingCheck = new PendingCheck("PendingChecker1", orders, 1000);
        ProcessedCheck processedCheck = new ProcessedCheck("ProcessedCheck1", orders, 1000);
        //Гонка потоков
        GeneratorOrders generatorOrders = new GeneratorOrders("gen1", orders, 2000, 15);
        GeneratorOrders generatorOrders2 = new GeneratorOrders("gen2", orders, 4000, 8);

        generatorOrders.start();
        generatorOrders2.start();

        pendingCheck.start();
        processedCheck.start();
    }

}
