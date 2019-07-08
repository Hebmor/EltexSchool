package ru.eltex.app.java.dev;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Devices implements Prototype_devices,ICrubAction {
    private UUID ID;
    private int Price;
    private static int CountProduct = 0;
    private String Firm;
    private String Model;
    private  String OS;
    private  String Name;

    private String [] random_database_Firma = {"Samsung","Huawei","Lenovo","Xiaomi ","OnePlus ","LG ","SONY","Apple"};
    private String [] random_database_Model = {"K1","N4","Redmi Note 7","C2","A1","EE","RB"};
    private String [] random_database_OS = {"Android","IOS","Windows Phone"};
    private String [] random_database_Name = {"Xiaomi Redmi 7 3/32GB","Xiaomi Redmi Note 6 Pro 4/64GB","HUAWEI P Smart (2019) 3/32GB","Samsung Galaxy A10","Apple iPhone 8 64GB","HUAWEI Y5 (2019) 32GB","Samsung Galaxy S10e 6/128GB"};

    protected Scanner in = new Scanner(System.in);

    public Devices()
    {
        ID = UUID.randomUUID();
        CountProduct++;
    }
    public Devices(int _Price, String _Firma, String _Model, String _OS, String _Name)
    {
        this.ID = UUID.randomUUID();
        this.Price = _Price;
        this.Firm = _Firma;
        this.Model = _Model;
        this.OS = _OS;
        this.Name = _Name;

        CountProduct++;
    }


    @Override
    public UUID getID() {
        return ID;
    }

    @Override
    public int getPrice() {
        return Price;
    }

    @Override
    public int getCountProduct() {
        return CountProduct;
    }

    @Override
    public String getFirm() {
        return Firm;
    }

    @Override
    public String getModel() {
        return Model;
    }

    @Override
    public String getOS() {
        return OS;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setID(UUID _ID) {
        this.ID = _ID;
    }

    @Override
    public void setPrice(int _Price) {
        this.Price = _Price;
    }

    @Override
    public void setCountProduct(int _CountProduct) {
        CountProduct = _CountProduct;
    }

    @Override
    public void setFirm(String _Firma) {
        this.Firm = _Firma;
    }

    @Override
    public void setModel(String _Model) {
        this.Model = _Model;
    }

    @Override
    public void setOS(String _OS) {
        this.OS = _OS;
    }

    @Override
    public void setName(String _Name) {
        this.Name = _Name;
    }

    @Override
    public void printID() {
        System.out.println("ID: "+this.ID );
    }

    @Override
    public void printPrice() {
        System.out.println("Цена: "+this.Price );
    }

    @Override
    public void printIountProduct() {
        System.out.println("Количество продуктов: "+CountProduct );
    }

    @Override
    public void printFirma() {
        System.out.println("Фирма: "+this.Firm);
    }

    @Override
    public void printModel() {
        System.out.println("Модель: "+this.Model );
    }

    @Override
    public void printOS() {
        System.out.println("Операционная система: "+this.OS );
    }

    @Override
    public void printName() {
        System.out.println("Нахвание: "+this.Name );
    }

    @Override
    public void create() {

        this.Firm = (String) getRandArrayElement(random_database_Firma);
        this.Name = (String) getRandArrayElement(random_database_Name);
        this.OS = (String) getRandArrayElement(random_database_OS);
        this.Model = (String) getRandArrayElement(random_database_Model);

        this.ID = UUID.randomUUID();
        this.Price = new Random().nextInt(999999);
    }

    @Override
    public void read() {

        System.out.println("------------------------------------------------------");
        System.out.println("Устройство с номером " + this.ID);
        System.out.println("Название:" + this.Name);
        System.out.println("Модель:" + this.Model);
        System.out.println("ОС:" + this.OS);
        System.out.println("Фирма:" + this.Firm);

    }

    @Override
    public void update() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название");
        this.setName(in.nextLine());
        System.out.println("Введите модель");
        this.setModel(in.nextLine());
        System.out.println("Введите фирму");
        this.setFirm(in.nextLine());
        System.out.println("Введите операционную систему");
        this.setOS(in.nextLine());
        System.out.println("Введите цену");
        this.setPrice(in.nextInt());
    }


    @Override
    public void delete() {
        this.ID = null;
        this.Price = 0;
        this.Firm = "";
        this.Model = "";
        this.OS = "";
        this.Name  = "";

        CountProduct = 0;
    }
    protected Object getRandArrayElement(Object [] array){
        return array[new Random().nextInt(array.length)];
    }

}
