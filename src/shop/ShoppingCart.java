package shop;

import dev.abstract_devices;

import java.util.LinkedList;

public class ShoppingCart {


    private Credentials credential;
    private LinkedList<abstract_devices> devicesLinkedList;

    public ShoppingCart(Credentials _credential,LinkedList<abstract_devices> _devicesLinkedList) {
        this.devicesLinkedList = _devicesLinkedList;
    }
    public void setCredential(Credentials credential) {
        this.credential = credential;
    }
    public void add(abstract_devices _device)
    {
        this.devicesLinkedList.add(_device);
    }
    public void delete(int idx)
    {
        this.devicesLinkedList.remove(idx);
    }
    public void delete(abstract_devices obj)
    {
        this.devicesLinkedList.remove(obj);
    }

}
