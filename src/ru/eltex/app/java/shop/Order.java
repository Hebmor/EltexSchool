package ru.eltex.app.java.shop;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Order {

    private ShoppingCart shoppingCart;
    private Date  timeCreate;
    private Date timeWait;

    public enum stateWork
    {
        PENDING ("в ожидании"),
        PROCESSED ("обработан");

        public String getTitle() {
            return title;
        }

        private String title;

        stateWork(String title) {
            this.title = title;
        }
        @Override
        public String toString()
        {
            return  title;
        }
    };

    stateWork state;

    public Order()
    {
        timeWait = new Date(timeCreate.getTime() + TimeUnit.MINUTES.toMillis(20));
    }

    public  void startOrder()
    {
        timeCreate = new Date();
    }
    public Order(ShoppingCart _shoppingCard)
    {
        this.shoppingCart = _shoppingCard;
        this.setState(stateWork.PENDING);

        startOrder();
        timeWait = new Date(timeCreate.getTime() + TimeUnit.MINUTES.toMillis(20));

    }
    public void setState(stateWork _state)
    {
        this.state = state;
    }
    public stateWork getState()
    {
        return this.state;
    }
    boolean checkTime()
    {
        if( new Date().getTime() - timeCreate.getTime() > TimeUnit.MINUTES.toMillis(20))
            return true;
        else
            return false;
    }
    boolean isNOTvalidOrder()
    {
        return (checkTime() || getState() == stateWork.PROCESSED);

    }
    public void showOrder()
    {
        this.shoppingCart.showAllObjects();
    }

}
