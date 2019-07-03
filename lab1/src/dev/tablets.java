package dev;

import java.util.Scanner;

public class tablets extends  abstract_devices {

    public String GPU;
    public String screen_resolution;

    private String [] random_database_GPU = {"Apple A12X Bionic GPU","Qualcomm Adreno 640","ARM Mali-G76 MP10","PowerVR GXA6850","NVIDIA Tegra K1 Kepler GPU","ARM Mali-400 MP2","PowerVR SGX530"};
    private String [] random_database_screen_resolution = {"640x480","800x600","1024x748","1360x768","1920x1080","2560x1440","3440x1440"};

    public tablets(int _Price, String _Firma, String _Model, String _OS, String _Name, String GPU) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.GPU = GPU;
    }

    public tablets(int _Price, String _Firma, String _Model, String _OS, String _Name, String[] random_database_screen_resolution) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.random_database_screen_resolution = random_database_screen_resolution;
    }

    public tablets(String GPU) {
        this.GPU = GPU;
    }

    public tablets(String[] random_database_GPU) {
        this.random_database_GPU = random_database_GPU;
    }

    public tablets() {

    }

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
    @Override
    public  void create()
    {
        super.create();
        GPU = (String) getRandArrayElement(random_database_GPU);
        screen_resolution = (String) getRandArrayElement(random_database_screen_resolution);
    }
    @Override
    public  void read()
    {
        super.read();
        System.out.println("GPU: " + this.GPU);
        System.out.println("Разрешение экрана: " + this.screen_resolution);
    }
}
