package ru.eltex.app.java.shop;

import java.util.ArrayList;

public abstract class ACheck {

    public void OrdersCheck(ArrayList<Order> ordersArrayList) {
        for (Order order : ordersArrayList)
            if (order.isNOTvalidOrder())
                ordersArrayList.remove(order);
    }

    public boolean checkState(Order.stateWork _state, Order _order) {
        return _order.getState().equals(_state);
    }
}
