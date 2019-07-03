package dev;

import java.util.Scanner;

public class tablets extends  abstract_devices {

    public String GPU;
    public String screen_resolution;

    public void setScreen_resolution() {

        int width = 0;
        int height = 0;
        System.out.println("Введите разрешение по горизонтале");
        width = in.nextInt();
        System.out.println("Введите разрешение по вертикале");
        height = in.nextInt();
        this.screen_resolution = String.valueOf(width) + "x" + String.valueOf(height);
    }
    @Override
    public  void update()
    {
        System.out.println("Введите тип  видеопроцессор");
        this.GPU = in.nextLine();
        System.out.println("Введите тип  разрешение экрана");
        this.setScreen_resolution();
    }
    @Override
    public void delete()
    {
        this.screen_resolution = "";
        this.GPU = "";
    }
}
