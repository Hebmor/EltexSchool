package ru.eltex.app.java.shop;

import java.io.Serializable;
import java.util.Scanner;

public class Credentials implements Serializable {

    private int ID = 0;
    private transient Scanner in = new Scanner(System.in);
    private String Familia;
    private String Name;
    private String Ochers;
    private String email;
    static transient private int countCredentials = 0;

    public Credentials() {
        countCredentials++;
        ID = countCredentials;
    }

    public Credentials(int ID, String familia, String name, String ochers, String email) {
        countCredentials++;
        ID = countCredentials;
        this.ID = ID;
        this.Familia = familia;
        this.Name = name;
        this.Ochers = ochers;
        this.email = email;
    }

    public Credentials(String familia, String name, String ochers, String email) {
        countCredentials++;
        ID = countCredentials;
        this.Familia = familia;
        this.Name = name;
        this.Ochers = ochers;
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

    public String getOchers() {
        return Ochers;
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

    public void setOchers(String ochers) {
        Ochers = ochers;
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
        setOchers(in.nextLine());
        System.out.println("Введите email:");
        setEmail(in.nextLine());
    }



}