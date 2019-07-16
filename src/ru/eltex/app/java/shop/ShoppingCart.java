package ru.eltex.app.java.shop;

import ru.eltex.app.java.products.Devices;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.UUID;

public class ShoppingCart<T extends Devices> {

    private Credentials credential;
    private LinkedList<T> devicesLinkedList;
    private HashSet<UUID> productIdentifiers;


    public ShoppingCart(Credentials _credential, LinkedList<T> _devicesLinkedList) {
        this.devicesLinkedList = _devicesLinkedList;
        this.credential = _credential;

    }

    public ShoppingCart(Credentials _credential, T _device) {
        this.credential = _credential;
        this.devicesLinkedList.add(_device);
    }
    public void setCredential(Credentials credential) {
        this.credential = credential;
    }

    public void add(T _device) {
        this.devicesLinkedList.add(_device);
        this.productIdentifiers.add(_device.getID());
    }

    public void delete(int idx) {
        this.devicesLinkedList.remove(idx);
        this.productIdentifiers.remove(this.devicesLinkedList.get(idx).getID());
    }

    public void delete(T obj) {
        this.devicesLinkedList.remove(obj);
        this.productIdentifiers.remove(obj.getID());
    }

    public Devices searchByID(UUID ID) {

        if (!productIdentifiers.isEmpty())
            if (productIdentifiers.contains(ID))
                for (T device : devicesLinkedList)
                    if (device.getID().equals(ID))
                        return device;

        return null;
    }

    public boolean isExistDeviceByID(UUID ID) {
        if (productIdentifiers.isEmpty())
            return false;
        return productIdentifiers.contains(ID);
    }

    public void showAllObjects() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Информация о покупателе: " + credential.getID());
        System.out.println("Заказчик: " + credential.getFamilia() + " " + credential.getName() + " " + credential.getOchers());
        System.out.println("EMAIL: " + credential.getEmail());
        System.out.println("-----------------------------------------------------------");
        System.out.println("**************************Покупки**************************");
        for (T device : devicesLinkedList)
            device.read();
        System.out.println("-----------------------------------------------------------");

    }

}
