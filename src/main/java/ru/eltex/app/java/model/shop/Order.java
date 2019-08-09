package ru.eltex.app.java.model.shop;


import com.fasterxml.jackson.annotation.*;
import ru.eltex.app.java.config.View;

import java.io.Serializable;
import java.util.Date;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ID", "state", "timeCreate", "timeWait_ms", "shoppingCart"})
public class Order implements Serializable {

    @JsonView(View.Summary.class)
    @JsonProperty("state")
    stateWork state;
    @JsonView(View.Summary.class)
    @JsonProperty("timeCreate")
    private Date timeCreate;
    @JsonView(View.Summary.class)
    @JsonProperty("timeWait_ms")
    private long timeWait_ms = 0;
    @JsonView(View.Summary.class)
    @JsonProperty("shoppingCart")
    private ShoppingCart shoppingCart;
    @JsonView(View.Summary.class)
    @JsonProperty("ID")
    private int ID;
    @JsonIgnore
    private static int countID = 0;


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
    public Order(@JsonProperty("timeCreate") Date timeCreate, @JsonProperty("timeWait_ms") long timeWait_ms, @JsonProperty("state") stateWork state, @JsonProperty("shoppingCart") ShoppingCart shoppingCart, @JsonProperty("ID") int ID) {
        this.timeCreate = timeCreate;
        this.timeWait_ms = timeWait_ms;
        this.state = state;
        this.shoppingCart = shoppingCart;
        this.ID = ID;
    }

    public Order() {
        state = stateWork.PENDING;
        startOrder();
        this.ID = countID;
        countID++;
    }

    public Order(ShoppingCart shoppingCart) {
        this.setState(stateWork.PENDING);
        this.shoppingCart = shoppingCart;
        startOrder();
        this.ID = countID;
        countID++;
    }

    public void startOrder() {
        timeCreate = new Date();
    }


    public Order(ShoppingCart _shoppingCard, long _timeWait) {
        this.shoppingCart = _shoppingCard;
        this.setState(stateWork.PENDING);

        startOrder();
        timeWait_ms = _timeWait;
        this.ID = countID;
        countID++;

    }

    public void setState(stateWork _state) {
        this.state = _state;
    }

    @JsonIgnore
    public stateWork getState() {
        return this.state;
    }

    boolean checkTime() {
        return ((new Date().getTime() - timeCreate.getTime()) > timeWait_ms);
    }

    boolean isNOTvalidOrder() {
        return (checkTime() || getState() == stateWork.PROCESSED);

    }

    public void showOrder() {
        System.out.println("Заказ #:" + this.getID());
        System.out.println("Статус:" + this.getState());
        System.out.println("Время обработки:" + this.getTimeWait_ms());
        this.shoppingCart.showAllObjects();
    }

    public int getID() {
        return ID;
    }

    public static int getCountID() {
        return countID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @JsonIgnore
    public long getTimeWait_ms() {
        return timeWait_ms;
    }

    public long getRemainingTime() {
        return (timeWait_ms - (new Date().getTime() - timeCreate.getTime()));
    }
}
