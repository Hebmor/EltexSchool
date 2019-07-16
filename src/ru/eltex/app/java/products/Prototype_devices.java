package ru.eltex.app.java.products;

import java.util.UUID;

public interface Prototype_devices {

    UUID getID();
    int getPrice();
    int getCountProduct();
    String getFirm();
    String getModel();
    String getOS();
    String getName();

    void setID(UUID _ID);
    void setPrice(int _Price);
    void setCountProduct(int _CountProduct);
    void setFirm(String F_irma);
    void setModel(String _Model);
    void setOS(String _OS);
    void setName(String _Name);


    void printID();
    void printPrice();
    void printIountProduct();
    void printFirma();
    void printModel();
    void printOS();
    void printName();

}
