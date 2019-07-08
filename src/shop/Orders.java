package shop;

import java.util.ArrayList;

public class Orders {
    private ArrayList<Order> ordersArrayList = new ArrayList<Order>();
    public void add(Order order)
    {
        ordersArrayList.add(order);
    }
    public Order get(int idx)
    {
        if(idx < 0 || idx > ordersArrayList.size())
        {
            System.out.println("Ошибка заказ не может быть получен!");
            return null;
        }
        return ordersArrayList.get(idx);
    }
    public  void set(Order order,int idx)
    {
        ordersArrayList.add(idx,order);
    }
    public  void Checkout(ShoppingCart shoppingCart)
    {
        this.ordersArrayList.add(new Order(shoppingCart));
    }
    public void OrdersCheck()
    {
        for(Order order : ordersArrayList)
            if(order.isNOTvalidOrder())
                ordersArrayList.remove(order);
    }
    public void showAllOrders()
    {
        OrdersCheck();
        for(Order order : ordersArrayList)
        {
            order.showOrder();
        }
    }

}
