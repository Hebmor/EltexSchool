package dev;

import java.io.Console;
import java.util.Scanner;

public class phones extends  abstract_devices{

    public String typeBody;

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
}
