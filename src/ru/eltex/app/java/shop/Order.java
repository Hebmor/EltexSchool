package ru.eltex.app.java.shop;


import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private ShoppingCart shoppingCart;
    private Date timeCreate;
    private long timeWait_ms = 0;

    public enum stateWork implements Serializable {
        PENDING("в ожидании"),
        PROCESSED("обработан");

        public String getTitle() {
            return title;
        }

        private String title;

        stateWork(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    stateWork state;

    public Order() {
        state = stateWork.PENDING;
        startOrder();
    }

    public Order(ShoppingCart shoppingCart) {
        this.setState(stateWork.PENDING);
        this.shoppingCart = shoppingCart;
        startOrder();
    }

    public void startOrder() {
        timeCreate = new Date();
    }


    public Order(ShoppingCart _shoppingCard, long _timeWait) {
        this.shoppingCart = _shoppingCard;
        this.setState(stateWork.PENDING);

        startOrder();
        timeWait_ms = _timeWait;


    }

    public void setState(stateWork _state) {
        this.state = _state;
    }

    public stateWork getState() {
        return this.state;
    }

    boolean checkTime() {
        return (new Date().getTime() - timeCreate.getTime() > timeCreate.getTime() + timeWait_ms);
    }

    boolean isNOTvalidOrder() {
        return (checkTime() || getState() == stateWork.PROCESSED);

    }

    public void showOrder() {
        System.out.println("Статус:" + this.getState());
        System.out.println("Время обработки:" + this.getTimeWait_ms());
        this.shoppingCart.showAllObjects();
    }

    public long getTimeWait_ms() {
        return timeWait_ms;
    }
}
