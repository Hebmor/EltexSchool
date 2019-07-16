package ru.eltex.app.java.products;

import java.io.Serializable;
import java.util.Random;

public class Smartphones extends Devices implements Serializable {

    public Smartphones(String[] random_database_typeSIMcard) {
        this.random_database_typeSIMcard = random_database_typeSIMcard;
    }

    public String typeSIMcard;
    private transient String[] random_database_typeSIMcard = {"micro-SIM", "обычная"};
    public  int countSIMcard = 0;

    public Smartphones(String typeSIMcard) {
        this.typeSIMcard = typeSIMcard;
    }

    public Smartphones(int _Price, String _Firma, String _Model, String _OS, String _Name, String typeSIMcard) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.typeSIMcard = typeSIMcard;
    }

    public Smartphones(int _Price, String _Firma, String _Model, String _OS, String _Name, String[] random_database_typeSIMcard) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.random_database_typeSIMcard = random_database_typeSIMcard;
    }

    public Smartphones(int _Price, String _Firma, String _Model, String _OS, String _Name, int countSIMcard) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.countSIMcard = countSIMcard;
    }

    public Smartphones(int countSIMcard) {
        this.countSIMcard = countSIMcard;
    }

    public Smartphones() {

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
        int variant = 0;
        super.update();
        while (true) {
            System.out.println("Введите (цифра) тип корпуса (1.micro-SIM, 2.обычная) (цифра без точки!)");
            variant = in.nextInt();
            switch (variant) {
                case 1: {
                    this.typeSIMcard = "micro-SIM";
                    return;
                }
                case 2: {
                    this.typeSIMcard = "обычная";
                    return;
                }
                default: {
                    System.out.println("Ошибка не корректный вариант! Повторите ввод");

                }
            }
        }

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
        countSIMcard = new Random().nextInt(2) + 1;
    }
    @Override
    public  void read()
    {
        super.read();
        System.out.println("Тип СИМ: " + this.typeSIMcard);
        System.out.println("Кол-во СИМ: " + this.countSIMcard);
    }
}
