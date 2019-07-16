package ru.eltex.app.java.shop;

import ru.eltex.app.java.products.Devices;
import ru.eltex.app.java.products.Phones;
import ru.eltex.app.java.products.Smartphones;
import ru.eltex.app.java.products.Tablets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class GeneratorOrders extends ACheck {

    private int maxRand = 10;
    private Random random = new Random();

    public GeneratorOrders() {
        super();

    }

    public GeneratorOrders(String string) {
        super(string);

    }

    public GeneratorOrders(String nameThread, Orders _orders, long timeInterval, int maxRand) {
        super(nameThread, _orders, timeInterval);
        this.maxRand = maxRand;
    }


    public void setTimeInterval(long timeInterval) {
        this.IntervalTime = timeInterval;
    }

    public void setMaxRand(int maxRand) {
        this.maxRand = maxRand;
    }


    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(this.IntervalTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Order new_order = getGenerateOrder();
                if (!(new_order == null)) {
                    this.orders.add(new_order);
                } else {
                    System.out.println("Ошибка генерации Order!");
                }
                new_order.showOrder();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private Order getGenerateOrder() throws IOException {
        Credentials credentials = new Credentials();
        credentials.GenerateFieldsCredentials();
        LinkedList<Devices> devicesLinkedList = new LinkedList<>();
        for (int i = 0; i < random.nextInt(maxRand) + 1; i++) {
            Devices device = getRandomDevice();
            if (!(device == null))
                devicesLinkedList.add(device);
            else
                System.out.println("Ошибка генерации потомков Devices!");
        }

        return new Order(new ShoppingCart<Devices>(credentials, devicesLinkedList), 1000 + (long) (new Random().nextDouble() * (100000 - 1000)));

    }

    private Devices getRandomDevice() {
        Devices tmp = null;
        String[] types = {"Phones", "Smartphones", "Tablets"};
        String type = (String) Devices.getRandArrayElement(types);
        switch (type) {
            case "Phones": {
                tmp = new Phones();
                tmp.create();
                break;
            }
            case "Smartphones": {

                tmp = new Smartphones();
                tmp.create();
                break;
            }

            case "Tablets": {

                tmp = new Tablets();
                tmp.create();
                break;
            }
        }
        return tmp;
    }

}
