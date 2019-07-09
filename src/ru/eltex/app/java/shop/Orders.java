package ru.eltex.app.java.shop;

import java.util.ArrayList;

public class Orders<T extends Order> {
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

    public void Checkout(ShoppingCart shoppingCart) {
        this.ordersArrayList.add((T) new Order(shoppingCart));
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

    public void delete(T _order) {
        ordersArrayList.remove(_order);
    }
}
