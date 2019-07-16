package ru.eltex.app.java.products;

import java.io.Serializable;

public class Phones extends Devices implements Serializable {

    private String typeBody;
    private transient String[] random_database_typeBode = {"классический", "раскладушка"};

    public Phones(String[] random_database_typeBode) {
        this.random_database_typeBode = random_database_typeBode;
    }

    public Phones(String typeBody) {
        this.typeBody = typeBody;
    }

    public Phones() {

    }

    @Override
    public void update()
    {
        int variant = 0;
        super.update();


        while (true) {
            System.out.println("Введите (цифра) тип корпуса (1.классический, 2.раскладушка) (цифра без точки!)");
            variant = in.nextInt();
            switch (variant) {
                case 1: {
                    this.setTypeBody(new String("классический"));
                    return;
                }
                case 2: {
                    this.setTypeBody(new String("раскладушка"));
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
        super.delete();
       this.typeBody = "";
    }
    @Override
    public  void create()
    {
        super.create();
        setTypeBody((String) getRandArrayElement(random_database_typeBode));
    }
    @Override
    public  void read()
    {
        super.read();
        System.out.println("Тип корпуса: " + this.getTypeBody());
    }

    public String getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(String typeBody) {
        this.typeBody = typeBody;
    }
}
