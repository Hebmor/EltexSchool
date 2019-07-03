package dev;

import java.util.Scanner;

public class smartphones extends abstract_devices {

    public String typeSIMcard;
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
}
