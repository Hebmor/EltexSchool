package shop;

import dev.Devices;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.UUID;

public class ShoppingCart {


    private Credentials credential;
    private LinkedList<Devices> devicesLinkedList;
    private HashSet<UUID> productIdentifiers;


    public ShoppingCart(Credentials _credential,LinkedList<Devices> _devicesLinkedList) {
        this.devicesLinkedList = _devicesLinkedList;
        this.credential = _credential;

    }
    public void setCredential(Credentials credential) {
        this.credential = credential;
    }
    public void add(Devices _device)
    {
        this.devicesLinkedList.add(_device);
        this.productIdentifiers.add(_device.getID());
    }
    public void delete(int idx)
    {
        this.devicesLinkedList.remove(idx);
        this.productIdentifiers.remove(this.devicesLinkedList.get(idx).getID());
    }
    public void delete(Devices obj)
    {
        this.devicesLinkedList.remove(obj);
        this.productIdentifiers.remove(obj.getID());
    }
    public Devices searchByID(UUID ID)
    {

        if(!productIdentifiers.isEmpty())
            if(productIdentifiers.contains(ID))
                for (Devices device : devicesLinkedList)
                    if (device.getID().equals(ID))
                        return device;

        return null;
    }
    public  boolean isExistDeviceByID(UUID ID)
    {
        if(productIdentifiers.isEmpty())
            return false;
        return productIdentifiers.contains(ID);
    }
    public void showAllObjects()
    {
        System.out.println("------------------------------------------------");
        System.out.println("Информация об покупателе: " + credential.getID());
        System.out.println("Заказчик: " + credential.getFamilia() + " " + credential.getName() + " " + credential.getOchestvo());
        System.out.println("EMAIL: " + credential.getEmail());
        System.out.println("------------------------------------------------");
        System.out.println("*********************Покупки********************");
        for (Devices device : devicesLinkedList)
            device.read();
        System.out.println("------------------------------------------------");

    }

}
