package ru.eltex.app.java.lab1;


import ru.eltex.app.java.products.Devices;
import ru.eltex.app.java.products.Phones;
import ru.eltex.app.java.products.Smartphones;
import ru.eltex.app.java.products.Tablets;

import java.util.LinkedList;

public class Main {

    private static LinkedList<Devices> DevicesArray = null;

    public static void main(String[] args) {

        RunningInput(args);

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

        if ("Phones".equals(typeObject)) {
            for (int i = 0; i < countObject; i++) {
                DevicesArray.add(new Phones());
                System.out.println("Ввод объекта: " + ++counter);
                ((Phones) DevicesArray.get(i)).update();
            }
        } else if ("Smartphones".equals(typeObject)) {
            for (int i = 0; i < countObject; i++) {
                DevicesArray.add(new Smartphones());
                System.out.println("Ввод объекта: " + ++counter);
                ((Smartphones) DevicesArray.get(i)).update();
            }
        } else if ("Tablets".equals(typeObject)) {
            for (int i = 0; i < countObject; i++) {
                DevicesArray.add(new Tablets());
                System.out.println("Ввод объекта: " + ++counter);
                ((Tablets) DevicesArray.get(i)).update();
            }
        } else {
            System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
            System.out.println("java code.java {количество вводимых объектов} {phones/smartphones/tablets}");
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

        if ("Phones".equals(typeObject)) {
            for (int i = 0; i < countObject; i++) {
                DevicesArray.add(new Phones());
                ((Phones) DevicesArray.get(i)).create();
            }
        } else if ("Smartphones".equals(typeObject)) {
            for (int i = 0; i < countObject; i++) {
                DevicesArray.add(new Smartphones());
                ((Smartphones) DevicesArray.get(i)).create();
            }
        } else if ("Tablets".equals(typeObject)) {
            for (int i = 0; i < countObject; i++) {
                DevicesArray.add(new Tablets());
                ((Tablets) DevicesArray.get(i)).create();
            }
        } else {
            System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
            System.out.println("java code.java {количество вводимых объектов} {phones/smartphones/tablets}");
        }
    }

}
