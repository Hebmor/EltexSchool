package ru.eltex.app.java.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Scanner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)
public class Credentials implements Serializable {


    private int ID = 0;

    private transient Scanner in = new Scanner(System.in);

    private String Families;

    private String Name;

    private String Ochers;

    private String email;

    static transient private int countCredentials = 0;

    public Credentials() {
        ID = countCredentials;
        countCredentials++;
    }

    public Credentials(int ID, String families, String name, String ochers, String email) {
        ID = countCredentials;
        countCredentials++;
        this.ID = ID;
        this.Families = families;
        this.Name = name;
        this.Ochers = ochers;
        this.email = email;
    }

    public Credentials(String families, String name, String ochers, String email) {
        ID = countCredentials;
        countCredentials++;
        this.Families = families;
        this.Name = name;
        this.Ochers = ochers;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public String getFamilies() {
        return Families;
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

    public void setFamilies(String families) {
        Families = families;
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
        setFamilies(in.nextLine());
        System.out.println("Введите Имя: ");
        setName(in.nextLine());
        System.out.println("Введите Отчество:");
        setOchers(in.nextLine());
        System.out.println("Введите email:");
        setEmail(in.nextLine());
    }


}
