package ru.eltex.app.java.shop;

public class ProcessedCheck extends ACheck {

    ProcessedCheck(String name) {
        super(name);
    }

    public ProcessedCheck(String nameThread, Orders orders, long _IntervalTime) {
        super(nameThread, orders, _IntervalTime);
    }

    @Override
    public void run() {
        while (isInterrupted()) {

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
                if (checkState(Order.stateWork.PROCESSED, (Order) order)) {
                    orders.get_ordersArrayList().remove(order);
                }
        }
    }
}
