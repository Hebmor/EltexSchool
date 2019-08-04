package ru.eltex.app.java.model.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public abstract class AManageOrder implements IOrder {

    @Autowired
    private Orders orders;

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }

    @Override
    public Order readByID(int id) throws IOException, ClassNotFoundException, SimpleException {
        return null;
    }

    @Override
    public void saveById(int id) throws IOException, ClassNotFoundException, SimpleException {

    }

    @Override
    public ArrayList<Order> readAll() throws IOException, ClassNotFoundException, SimpleException {
        return null;
    }

    @Override
    public void saveAll() throws IOException {

    }

    protected Order SearchOrderByID(int ID, ArrayList<Order> _orderArrayList) {
        if (_orderArrayList == null)
            return null;
        for (Order order : _orderArrayList) {
            if (order.getID() == ID)
                return order;
        }
        return null;
    }
}
