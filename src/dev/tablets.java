package dev;

import java.util.Random;

public class tablets extends Devices {

    private String GPU;
    private  screen_resolution screen;
    public class screen_resolution
    {

        int height = 0;
        int width = 0;
        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public screen_resolution(int height, int width) {
            this.height = height;
            this.width = width;
        }

        public int getHeight() {
            return height;
        }
        public void clear()
        {
            this.height = 0;
            this.width = 0;
        }

    }

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
        screen.setHeight(height);
        screen.setWidth(width);
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
        this.screen.clear();
        this.GPU = "";
    }
    @Override
    public  void create()
    {
        super.create();
        GPU = (String) getRandArrayElement(random_database_GPU);
        screen.setHeight(new Random().nextInt(4000));
        screen.setWidth(new Random().nextInt(4000));
    }
    @Override
    public  void read()
    {
        super.read();
        System.out.println("GPU: " + this.GPU);
        System.out.println("Разрешение экрана: " + screen.getHeight() + "x" + screen.getWidth());
    }
}
