package ru.eltex.app.java.model.shop;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import ru.eltex.app.java.config.View;
import ru.eltex.app.java.model.products.Devices;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        property = "typeArray")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LinkedList.class, name = "linkedList"),
        @JsonSubTypes.Type(value = List.class, name = "list")


})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "shopping_card")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ShoppingCart<T extends Devices> implements Serializable {

    @JsonView(View.Summary.class)
    @JsonProperty
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "credential_id", unique = true)
    private Credentials credential;
    @JsonView(View.Summary.class)
    @JsonProperty
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Devices.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_card_id", nullable = false)
    private List<T> devicesLinkedList = new LinkedList<>();
    @JsonView(View.Summary.class)
    @JsonIgnore
    @Transient
    private HashSet<UUID> productIdentifiers;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private int id;

    @OneToOne(mappedBy = "shoppingCart")
    private Order order;
    @JsonCreator
    public ShoppingCart(@JsonProperty("credential") Credentials _credential, @JsonProperty("devicesLinkedList") LinkedList<T> _devicesLinkedList) {
        this.devicesLinkedList = _devicesLinkedList;
        this.credential = _credential;

    }

    public ShoppingCart(Credentials _credential, T _device) {
        devicesLinkedList = new LinkedList<T>();
        productIdentifiers = new HashSet<>();
        this.credential = _credential;
        this.devicesLinkedList.add(_device);
        productIdentifiers.add(_device.getID());
    }

    public ShoppingCart() {

    }

    public void setCredential(Credentials credential) {
        this.credential = credential;
    }

    public Credentials getCredential() {
        return credential;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<T> getDevicesLinkedList() {
        return devicesLinkedList;
    }
}
