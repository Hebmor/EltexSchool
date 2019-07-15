package ru.eltex.app.java.shop;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Credentials {

    private int ID = 0;
    private Scanner in = new Scanner(System.in);
    private String Familia;
    private String Name;
    private String Ochestvo;
    private String email;
    static private int countCredentials = 0;

    private DataBaseController nameDatabase = new DataBaseController("source/txt/NameBase");
    private DataBaseController familiesDatabase = new DataBaseController("source/txt/FamiliaBase");
    private DataBaseController otchDatabase = new DataBaseController("source/txt/OtchBase");
    private DataBaseController emailDatabase = new DataBaseController("source/txt/EmailBase");


    public Credentials() {
        countCredentials++;
        ID = countCredentials;
    }

    public Credentials(int ID, String familia, String name, String ochestvo, String email) {
        this.ID = ID;
        this.Familia = familia;
        this.Name = name;
        this.Ochestvo = ochestvo;
        this.email = email;
    }

    public Credentials(String familia, String name, String ochestvo, String email) {
        this.Familia = familia;
        this.Name = name;
        this.Ochestvo = ochestvo;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public String getFamilia() {
        return Familia;
    }

    public String getName() {
        return Name;
    }

    public String getOchestvo() {
        return Ochestvo;
    }

    public String getEmail() {
        return email;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFamilia(String familia) {
        Familia = familia;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setOchestvo(String ochestvo) {
        Ochestvo = ochestvo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void Input() {
        System.out.println("------------------------------------------------");
        System.out.println("Введите ФИО");
        System.out.println("Введите Фамилию: ");
        setFamilia(in.nextLine());
        System.out.println("Введите Имя: ");
        setName(in.nextLine());
        System.out.println("Введите Отчество:");
        setOchestvo(in.nextLine());
        System.out.println("Введите email:");
        setEmail(in.nextLine());
    }

    public void GenerateFieldsCredentials() {

        this.Name = nameDatabase.getRandomString();
        this.Familia = familiesDatabase.getRandomString();
        this.Ochestvo = otchDatabase.getRandomString();
        this.email = emailDatabase.getRandomString();
    }

}
