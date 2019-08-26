package ru.eltex.app.java.model.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(
        fieldVisibility = Visibility.ANY,
        getterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE,
        creatorVisibility = Visibility.NONE
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Service
public class Orders<T extends Order> implements Serializable {

    @JsonProperty("ordersArrayList")
    private ArrayList<T> ordersArrayList = new ArrayList<T>();

    public Orders() {
        ordersArrayList = new ArrayList<T>();
    }

    public Orders(Order order) {
        this.ordersArrayList.add((T) order);
    }

    public Orders(ArrayList<Order> arrayList) {
        this.ordersArrayList = (ArrayList<T>) arrayList;
    }

    public void add(T order) {
        if (ordersArrayList == null)
            ordersArrayList = new ArrayList<T>();
        ordersArrayList.add(order);
    }

    public T get(int idx) {
        if (idx < 0 || idx > ordersArrayList.size()) {
            System.out.println("Ошибка заказ не может быть получен!");
            return null;
        }
        return ordersArrayList.get(idx);
    }

    public void set(T order, int idx) {
        ordersArrayList.add(idx, order);
    }

    public void Checkout(ShoppingCart shoppingCart, long timeWait_ms) {
        this.ordersArrayList.add((T) new Order(shoppingCart, timeWait_ms));
    }

    public void OrdersCheck() {
        for (T order : ordersArrayList)
            if (order.isNOTvalidOrder())
                ordersArrayList.remove(order);
    }

    public void showAllOrders() {
        OrdersCheck();
        for (T order : ordersArrayList) {
            order.showOrder();
        }
    }

    public void setOrdersArrayList(ArrayList<T> ordersArrayList) {
        this.ordersArrayList = ordersArrayList;
    }

    public ArrayList<T> get_ordersArrayList() {
        return ordersArrayList;
    }

    public boolean delete(T _order) {
        return ordersArrayList.remove(_order);
    }

    public boolean delete(int id) throws SimpleException {
        for (Order order : ordersArrayList) {
            if (order.getID() == id) {
                ordersArrayList.remove(order);
                return true;
            }
        }
        throw new SimpleException("Нет такого заказа!", 1);
    }

}
