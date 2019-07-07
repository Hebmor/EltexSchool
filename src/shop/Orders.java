package shop;

import java.util.ArrayList;

public class Orders {
    private ArrayList<Order> orderArrayList = new ArrayList<Order>();
    public void add(Order order)
    {
        orderArrayList.add(order);
    }
    public Order get(int idx)
    {
        if(idx < 0 || idx > orderArrayList.size())
        {
            System.out.println("Ошибка заказ не может быть получен!");
            return null;
        }
        return orderArrayList.get(idx);
    }
    public  void set(Order order,int idx)
    {
        orderArrayList.add(idx,order);
    }

}
