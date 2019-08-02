package ru.eltex.app.java.model.shop;

import com.fasterxml.jackson.annotation.*;
import org.springframework.stereotype.Component;
import ru.eltex.app.java.model.products.Devices;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.UUID;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ShoppingCart<T extends Devices> implements Serializable {

    @JsonProperty
    private Credentials credential;
    @JsonProperty
    private LinkedList<T> devicesLinkedList;
    @JsonIgnore
    private HashSet<UUID> productIdentifiers;

    @JsonCreator
    public ShoppingCart(@JsonProperty("credential") Credentials _credential, @JsonProperty("devicesLinkedList") LinkedList<T> _devicesLinkedList) {
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

    @JsonIgnore
    public void add(T _device) {
        this.devicesLinkedList.add(_device);
        this.productIdentifiers.add(_device.getID());
    }

    @JsonIgnore
    public void delete(int idx) {
        this.devicesLinkedList.remove(idx);
        this.productIdentifiers.remove(this.devicesLinkedList.get(idx).getID());
    }

    @JsonIgnore
    public void delete(T obj) {
        this.devicesLinkedList.remove(obj);
        this.productIdentifiers.remove(obj.getID());
    }

    @JsonIgnore
    public ShoppingCart(@JsonProperty("credential") Credentials credential, @JsonProperty("devicesLinkedList") LinkedList<T> devicesLinkedList, @JsonProperty("productIdentifiers") HashSet<UUID> productIdentifiers) {
        this.credential = credential;
        this.devicesLinkedList = devicesLinkedList;
        this.productIdentifiers = productIdentifiers;
    }

    @JsonIgnore
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

    @JsonIgnore
    public void showAllObjects() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Информация о покупателе: " + credential.getID());
        System.out.println("Заказчик: " + credential.getFamilies() + " " + credential.getName() + " " + credential.getOchers());
        System.out.println("EMAIL: " + credential.getEmail());
        System.out.println("-----------------------------------------------------------");
        System.out.println("**************************Покупки**************************");
        for (T device : devicesLinkedList)
            device.read();
        System.out.println("-----------------------------------------------------------");

    }

}
