package com.main;


import dev.phones;
import dev.prototype_devices;
import dev.smartphones;
import dev.tablets;

import java.io.Console;
import java.util.Scanner;

public class Main {

    private static prototype_devices[]DevicesArray = null;
    public static void main(String[] args) {

        RunningInput(args);
    }
    public  static void RunningInput(String[] _args)
    {
        int countObject = 0;
        String typeObject;
        if(_args.length != 2) {
            System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
            System.out.println("java code.java {количество вводимых объектов} {вид представления}");
            return;
        }
        countObject = Integer.parseInt(_args[0]);
        typeObject = _args[1];
        switch (typeObject)
        {
            case  "phones":
            {
                DevicesArray = new phones[countObject];
                break;
            }
            case  "smartphones":
            {
                DevicesArray = new smartphones[countObject];
                break;
            }
            case  "tablets":
            {
                DevicesArray = new tablets[countObject];
                break;
            }
            default:
            {
                System.out.println("-----------------------Ошибка требуется терминальный ввод вида!---------------------------");
                System.out.println("java code.java {количество вводимых объектов} {phones/smartphones/tablets}");
            }

        }

    }
    public static  void ProcessInput()
    {
        Scanner in = new Scanner(System.in);

        if(DevicesArray !=null)
        {
            int counter = 0;
            for(var deviceObject : DevicesArray)
            {
                System.out.println("Ввод объекта" + ++counter);
                if(deviceObject instanceof prototype_devices ) {

                        if (deviceObject.getClass().getTypeName() == dev.phones.class.getTypeName())
                            ((dev.phones)deviceObject).update();
                        else  if (deviceObject.getClass().getTypeName() == dev.smartphones.class.getTypeName())
                            ((dev.smartphones)deviceObject).update();
                        else if (deviceObject.getClass().getTypeName() == dev.tablets.class.getTypeName())
                            ((dev.tablets)deviceObject).update();
                }
                System.out.println("------------------------------------------------------------------");


            }
        }
    }
}
