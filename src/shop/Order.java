package shop;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Order {

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

}
