package shop;

import java.util.LinkedList;

public class ShoppingCart {
    private LinkedList<Credentials> credentialsLinkedList;

    public ShoppingCart(LinkedList<Credentials> credentialsLinkedList) {
        this.credentialsLinkedList = credentialsLinkedList;
    }

    public void add(Credentials _credentials)
    {
        credentialsLinkedList.add(_credentials);
    }
    public void delete(int idx)
    {
        credentialsLinkedList.remove(idx);
    }
    public void delete(Credentials obj)
    {
        credentialsLinkedList.remove(obj);
    }
}
