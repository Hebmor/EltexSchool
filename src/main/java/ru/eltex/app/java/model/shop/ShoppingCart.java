package ru.eltex.app.java.model.shop;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Type;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "shopping_card")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ShoppingCart<T extends Devices> implements Serializable {

    @JsonView(View.Summary.class)
    @JsonProperty
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id2")
    private Credentials credential;
    @JsonView(View.Summary.class)
    @JsonProperty
    @ElementCollection
    @CollectionTable
    @Type(type = "ru,eltex.app.java.model.Devices")
    private List<T> devicesLinkedList = new List<T>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T1> T1[] toArray(T1[] t1s) {
            return null;
        }

        @Override
        public boolean add(T t) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, Collection<? extends T> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public T get(int i) {
            return null;
        }

        @Override
        public T set(int i, T t) {
            return null;
        }

        @Override
        public void add(int i, T t) {

        }

        @Override
        public T remove(int i) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<T> listIterator() {
            return null;
        }

        @Override
        public ListIterator<T> listIterator(int i) {
            return null;
        }

        @Override
        public List<T> subList(int i, int i1) {
            return null;
        }
    };
    @JsonView(View.Summary.class)
    @JsonIgnore
    @Transient
    private HashSet<UUID> productIdentifiers;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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
}
