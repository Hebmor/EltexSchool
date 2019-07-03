package dev;

import java.util.Scanner;

public class smartphones extends abstract_devices {

    public smartphones(String[] random_database_typeSIMcard) {
        this.random_database_typeSIMcard = random_database_typeSIMcard;
    }

    public String typeSIMcard;
    private String [] random_database_typeSIMcard = {"micro-SIM","обычная"};
    public  int countSIMcard = 0;

    public smartphones(String typeSIMcard) {
        this.typeSIMcard = typeSIMcard;
    }

    public smartphones(int _Price, String _Firma, String _Model, String _OS, String _Name, String typeSIMcard) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.typeSIMcard = typeSIMcard;
    }

    public smartphones(int _Price, String _Firma, String _Model, String _OS, String _Name, String[] random_database_typeSIMcard) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.random_database_typeSIMcard = random_database_typeSIMcard;
    }

    public smartphones(int _Price, String _Firma, String _Model, String _OS, String _Name, int countSIMcard) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.countSIMcard = countSIMcard;
    }

    public smartphones(int countSIMcard) {
        this.countSIMcard = countSIMcard;
    }


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
