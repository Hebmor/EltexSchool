package ru.eltex.app.java.model.shop;

public class PendingCheck extends ACheck {
    PendingCheck(String name) {
        super(name);
    }

    public PendingCheck(String nameThread, Orders orders, long _IntervalTime) {
        super(nameThread, orders, _IntervalTime);
    }


    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(this.IntervalTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            check();
        }
    }

    public void check() {
        for (Object order : this.orders.get_ordersArrayList()) {
            if (order instanceof Order)
                if (checkState(Order.stateWork.PENDING, (Order) order)) {
                    if (((Order) order).checkTime())
                        ((Order) order).state = Order.stateWork.PROCESSED;
                }
        }
    }
}

