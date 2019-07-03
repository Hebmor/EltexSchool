package dev;

import java.util.Scanner;

public class smartphones extends abstract_devices {

    public String typeSIMcard;
    private String [] random_database_typeSIMcard = {"micro-SIM","обычная"};
    public  int countSIMcard = 0;


    public void setTypeSIMcard(String typeSIMcard) {
        this.typeSIMcard = typeSIMcard;
    }

    public void setCountSIMcard(int countSIMcard) {
        this.countSIMcard = countSIMcard;
    }

    @Override
    public  void update()
    {
        super.update();
        System.out.println("Введите тип SIM-карты (micro-SIM, обычная)");
        this.typeSIMcard = in.nextLine();
    }
    @Override
    public void delete()
    {
        this.typeSIMcard = "";
        this.countSIMcard = 0;
    }
    @Override
    public  void create()
    {
        super.create();
        typeSIMcard = (String) getRandArrayElement(random_database_typeSIMcard);
    }
    @Override
    public  void read()
    {
        super.read();
        System.out.println("Тип СИМ: " + this.typeSIMcard);
        System.out.println("Кол-во СИМ: " + this.countSIMcard);
    }
}
