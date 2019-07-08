package com.main;


import dev.*;
import shop.Credentials;
import shop.Orders;
import shop.ShoppingCart;

import java.util.LinkedList;

public class Main {

    private static LinkedList<Devices> DevicesArray = null;
    public static void main(String[] args) {

        GenerateInput(args);
        TestShop();
    }
    public  static void RunningInput(String[] _args)
    {
        int countObject = 0;
        int counter = 0;
        String typeObject;
        if(_args.length != 2) {
            System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
            System.out.println("java code.java {количество вводимых объектов} {вид представления}");
            return;
        }
        countObject = Integer.parseInt(_args[0]);
        typeObject = _args[1];
        DevicesArray = new LinkedList<Devices>();

        switch (typeObject)
        {
            case  "phones":
            {

                for(int i = 0;i < countObject; i++)
                {
                    DevicesArray.add(new phones());
                    System.out.println("Ввод объекта: " + ++counter);
                    ((dev.phones)DevicesArray.get(i)).update();
                }
                break;
            }
            case  "smartphones":
            {
                for(int i = 0;i < countObject; i++)
                {
                    DevicesArray.add(new smartphones());
                    System.out.println("Ввод объекта: " + ++counter);
                    ((dev.smartphones)DevicesArray.get(i)).update();
                }
                break;
            }
            case  "tablets":
            {
                for(int i = 0;i < countObject; i++)
                {
                    DevicesArray.add(new tablets());
                    System.out.println("Ввод объекта: " + ++counter);
                    ((dev.tablets)DevicesArray.get(i)).update();
                }
                break;
            }
            default:
            {
                System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
                System.out.println("java code.java {количество вводимых объектов} {phones/smartphones/tablets}");
            }

        }
        printDevicesArray();
    }
    private static void printDevicesArray()
    {
        for(var deviceObject : DevicesArray) {
            System.out.println("-------------------------------------------------------------------");
            deviceObject.read();
            System.out.println("-------------------------------------------------------------------");
        }
    }
    private static  void TestShop()
    {
        ShoppingCart shoppingCart;
        Credentials credentials = new Credentials();
        Orders orders;
        credentials.Input();
        if(DevicesArray != null)
        {
            shoppingCart = new ShoppingCart(credentials,DevicesArray);

            orders = new Orders();
            orders.Checkout(shoppingCart);
            orders.OrdersCheck();
            orders.showAllOrders();
        }

    }
    public  static void GenerateInput(String[] _args)
    {
        int countObject = 0;
        int counter = 0;
        String typeObject;
        if(_args.length != 2) {
            System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
            System.out.println("java code.java {количество вводимых объектов} {вид представления}");
            return;
        }
        countObject = Integer.parseInt(_args[0]);
        typeObject = _args[1];
        DevicesArray = new LinkedList<Devices>();

        switch (typeObject)
        {
            case  "phones":
            {

                for(int i = 0;i < countObject; i++)
                {
                    DevicesArray.add(new phones());
                    ((dev.phones)DevicesArray.get(i)).create();
                }
                break;
            }
            case  "smartphones":
            {
                for(int i = 0;i < countObject; i++)
                {
                    DevicesArray.add(new smartphones());
                    ((dev.smartphones)DevicesArray.get(i)).create();
                }
                break;
            }
            case  "tablets":
            {
                for(int i = 0;i < countObject; i++)
                {
                    DevicesArray.add(new tablets());
                    ((dev.tablets)DevicesArray.get(i)).create();
                }
                break;
            }
            default:
            {
                System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
                System.out.println("java code.java {количество вводимых объектов} {phones/smartphones/tablets}");
            }

        }
      //  printDevicesArray();
    }

}
