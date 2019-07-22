package ru.eltex.app.java.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.*;

@JsonAutoDetect(
        fieldVisibility = Visibility.ANY,
        getterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE,
        creatorVisibility = Visibility.NONE
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Orders<T extends Order> implements Serializable {

    @JsonProperty("ordersArrayList")
    private ArrayList<T> ordersArrayList = new ArrayList<T>();


    public void add(T order) {
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

    public void delete(T _order) {
        ordersArrayList.remove(_order);
    }
}
