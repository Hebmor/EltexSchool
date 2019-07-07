package shop;


import dev.abstract_devices;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Order {

    private ShoppingCart shoppingCart;
    public Order()
    {
        timeCreate = new Date(timeCreate.getTime() + TimeUnit.MINUTES.toMillis(20));
    }
    private String[] stateWork = {"в ожидании","обработан"};
    private Date  timeCreate;
    private Date timeWait;

    public  void startOrder()
    {
        timeCreate = new Date();
    }
    public Order(ShoppingCart _shoppingCard)
    {
        this.shoppingCart = _shoppingCard;
    }

}
