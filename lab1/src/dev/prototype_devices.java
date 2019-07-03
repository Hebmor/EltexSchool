package dev;

public interface prototype_devices {

    int getID();
    int getPrice();
    int getCountProduct();
    String getFirma();
    String getModel();
    String getOS();
    String getName();

    void setID(int _ID);
    void setPrice(int _Price);
    void setCountProduct(int _CountProduct);
    void setFirma(String F_irma);
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
