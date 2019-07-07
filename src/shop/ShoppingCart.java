package shop;

import dev.abstract_devices;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.UUID;

public class ShoppingCart {


    private Credentials credential;
    private LinkedList<abstract_devices> devicesLinkedList;
    public HashSet<UUID> productIdentifiers;


    public ShoppingCart(Credentials _credential,LinkedList<abstract_devices> _devicesLinkedList) {
        this.devicesLinkedList = _devicesLinkedList;
        this.credential = _credential;

    }
    public void setCredential(Credentials credential) {
        this.credential = credential;
    }
    public void add(abstract_devices _device)
    {
        this.devicesLinkedList.add(_device);
        this.productIdentifiers.add(_device.getID());
    }
    public void delete(int idx)
    {
        this.devicesLinkedList.remove(idx);
        this.productIdentifiers.remove(this.devicesLinkedList.get(idx).getID());
    }
    public void delete(abstract_devices obj)
    {
        this.devicesLinkedList.remove(obj);
        this.productIdentifiers.remove(obj.getID());
    }
    public  abstract_devices searchByID(UUID ID)
    {

        if(!productIdentifiers.isEmpty())
            if(productIdentifiers.contains(ID))
                for (abstract_devices device : devicesLinkedList)
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

}
