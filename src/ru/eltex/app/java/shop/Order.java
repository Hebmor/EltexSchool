package ru.eltex.app.java.shop;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Order {

    private ShoppingCart shoppingCart;
    private Date timeCreate;
    private long timeWait = 0;

    public enum stateWork {
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
        timeWait = _timeWait;


    }

    public void setState(stateWork _state) {
        this.state = _state;
    }

    public stateWork getState() {
        return this.state;
    }

    boolean checkTime() {
        return (new Date().getTime() - timeCreate.getTime() > timeCreate.getTime() + timeWait);
    }

    boolean isNOTvalidOrder() {
        return (checkTime() || getState() == stateWork.PROCESSED);

    }

    public void showOrder() {
        this.shoppingCart.showAllObjects();
    }

}
