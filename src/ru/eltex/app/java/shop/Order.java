package ru.eltex.app.java.shop;


import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Date;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order implements Serializable {


    @JsonProperty("timeCreate")
    private Date timeCreate;
    @JsonProperty("timeWait_ms")
    private long timeWait_ms = 0;
    @JsonProperty("state")
    stateWork state;
    @JsonProperty("shoppingCart")
    private ShoppingCart shoppingCart;


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

    @JsonCreator
    public Order(@JsonProperty("timeCreate") Date timeCreate, @JsonProperty("timeWait_ms") long timeWait_ms, @JsonProperty("state") stateWork state, @JsonProperty("shoppingCart") ShoppingCart shoppingCart) {
        this.timeCreate = timeCreate;
        this.timeWait_ms = timeWait_ms;
        this.state = state;
        this.shoppingCart = shoppingCart;
    }

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

    @JsonIgnore
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

    @JsonIgnore
    public long getTimeWait_ms() {
        return timeWait_ms;
    }
}
