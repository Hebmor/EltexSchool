package dev;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class phones extends  abstract_devices{

    public String typeBody;
    private String [] random_database_typeBode = {"классический","раскладушка"};
    @Override
    public void update()
    {
        super.update();

        System.out.println("Введите тип корпуса (классический, раскладушка)");
        this.typeBody = in.nextLine();
    }
    @Override
    public void delete()
    {
        this.typeBody = "";
    }
    @Override
    public  void create()
    {
        super.create();
        typeBody = (String) getRandArrayElement(random_database_typeBode);
    }
    @Override
    public  void read()
    {
        super.read();
        System.out.println("Тип корпуса: " + this.typeBody);
    }
}
