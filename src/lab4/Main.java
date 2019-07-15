package lab4;


import ru.eltex.app.java.dev.Devices;
import ru.eltex.app.java.dev.Phones;
import ru.eltex.app.java.dev.Smartphones;
import ru.eltex.app.java.dev.Tablets;
import ru.eltex.app.java.shop.*;

import java.util.LinkedList;

public class Main {

    private static LinkedList<Devices> DevicesArray = null;

    public static void main(String[] args) {

        //GenerateInput(args);
        //TestShop();
        //printDevicesArray();
        Orders<Devices> orders = new Orders<Devices>();
        TestThread(orders);

    }

    public static void RunningInput(String[] _args) {
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
                    System.out.println("Ввод объекта: " + ++counter);
                    ((Phones) DevicesArray.get(i)).update();
                }
                break;
            }
            case "Smartphones": {
                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Smartphones());
                    System.out.println("Ввод объекта: " + ++counter);
                    ((Smartphones) DevicesArray.get(i)).update();
                }
                break;
            }
            case "Tablets": {
                for (int i = 0; i < countObject; i++) {
                    DevicesArray.add(new Tablets());
                    System.out.println("Ввод объекта: " + ++counter);
                    ((Tablets) DevicesArray.get(i)).update();
                }
                break;
            }
            default: {
                System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
                System.out.println("java code.java {количество вводимых объектов} {phones/smartphones/tablets}");
            }

        }

    }

    private static void printDevicesArray() {
        if (DevicesArray != null)
            for (var deviceObject : DevicesArray) {
                System.out.println("-------------------------------------------------------------------");
                deviceObject.read();
                System.out.println("-------------------------------------------------------------------");
            }
    }

    private static void TestShop() {
        ShoppingCart<Devices> shoppingCart;
        Credentials credentials = new Credentials();
        Orders<Order> orders = new Orders<>();
        credentials.Input();

        if (DevicesArray != null) {
            shoppingCart = new ShoppingCart(credentials, DevicesArray);


            orders.Checkout(shoppingCart);
            orders.OrdersCheck();
            orders.showAllOrders();
            TestThread(orders);
        }

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
        //  printDevicesArray();
    }

    public static void TestThread(Orders orders) {
        //PendingCheck pendingCheck = new PendingCheck("PendingChecker1",orders,1000);
        //ProcessedCheck processedCheck = new ProcessedCheck("ProcessedCheck1",orders,1000);
        GeneratorOrders generatorOrders = new GeneratorOrders("gen1", orders, 2000, 15);
        //pendingCheck.start();
        //processedCheck.start();
        generatorOrders.start();
        System.out.println("DONE");
    }

}
