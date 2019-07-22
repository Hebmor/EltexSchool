package ru.eltex.app.java.shop;

import java.io.IOException;
import java.util.ArrayList;

public abstract class AManageOrder implements IOrder {

    private Orders orders;

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }

    @Override
    public Order readByID(int id) throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public void saveById(int id) throws IOException {

    }

    @Override
    public ArrayList<Order> readAll() throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public void saveAll() throws IOException {

    }
}
