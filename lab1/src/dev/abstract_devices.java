package dev;

import java.util.Scanner;

public class abstract_devices implements prototype_devices,ICrubAction {
    private int ID = 1;
    private int Price;
    private static int CountProduct = 0;
    private String Firma;
    private String Model;
    private  String OS;
    private  String Name;

    private String [] random_database_Firma = {"Samsung","Huawei","Lenovo","Xiaomi ","OnePlus ","LG ","SONY","Apple"};
    private String [] random_database_Model = {"K1","N4","Redmi Note 7","C2","A1","EE","RB"};
    private String [] random_database_OS = {"Android","IOS","Windows Phone"};
    private String [] random_database_Name = {"","","","","","",""};

    protected Scanner in = new Scanner(System.in);

    public abstract_devices ()
    {
        ID = CountProduct;
        CountProduct++;
    }
    public abstract_devices(int _ID,int _Price,String _Firma,String _Model,String _OS,String _Name)
    {
        this.ID = _ID;
        this.Price = _Price;
        this.Firma = _Firma;
        this.Model = _Model;
        this.OS = _OS;
        this.Name = _Name;

        CountProduct++;
    }


    @Override
    public int getID() {
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
    public String getFirma() {
        return Firma;
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
    public void setID(int _ID) {
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
    public void setFirma(String _Firma) {
        this.Firma = _Firma;
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
        System.out.println("Фирма: "+this.Firma );
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


    }

    @Override
    public void read() {

        System.out.println("Устройство с номером " + this.ID);
        System.out.println("Название:" + this.Name);
        System.out.println("Модель:" + this.Model);
        System.out.println("ОС:" + this.OS);
        System.out.println("Фирма:" + this.Firma);

    }

    @Override
    public void update() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название");
        this.setName(in.nextLine());
        System.out.println("Введите фирму");
        this.setFirma(in.nextLine());
        System.out.println("Введите операционную систему");
        this.setOS(in.nextLine());
        System.out.println("Введите цену");
        this.setPrice(in.nextInt());
    }


    @Override
    public void delete() {
        this.ID = 0;
        this.Price = 0;
        this.Firma = "";
        this.Model = "";
        this.OS = "";
        this.Name  = "";

        CountProduct = 0;
    }

}
