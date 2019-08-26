package ru.eltex.app.java.model.shop;

import org.springframework.stereotype.Service;
import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.products.Phones;
import ru.eltex.app.java.model.products.Smartphones;
import ru.eltex.app.java.model.products.Tablets;

import java.util.LinkedList;
import java.util.Random;

@Service
public class GeneratorOrders extends ACheck {

    private int maxCountDevices = 10;
    private int maxCountOrders = 1;
    private Random random = new Random();
    private boolean randomFlag = false;
    private boolean repeatFlag = false;
    private DataBaseController nameDatabase = new DataBaseController("src/main/resources/txt/NameBase");
    private DataBaseController familiesDatabase = new DataBaseController("src/main/resources/txt/FamiliaBase");
    private DataBaseController otchDatabase = new DataBaseController("src/main/resources/txt/OtchBase");
    private DataBaseController emailDatabase = new DataBaseController("src/main/resources/txt/EmailBase");

    public GeneratorOrders() {
        super();

    }

    public GeneratorOrders(String string) {
        super(string);

    }

    public GeneratorOrders(String nameThread, Orders _orders, long timeInterval, int maxCountDevices, int maxCountOrders, boolean randomFlag, boolean repeatFlag) {
        super(nameThread, _orders, timeInterval);
        setMaxCountDevices(maxCountDevices);
        setMaxCountOrders(maxCountOrders);

        setRandomFlag(randomFlag);
        setRepeatFlag(repeatFlag);
    }

    public boolean isRandomFlag() {
        return randomFlag;
    }
    public boolean isRepeatFlag() {
        return repeatFlag;
    }
    public void setTimeInterval(long timeInterval) {
        this.IntervalTime = timeInterval;
    }
    public void setMaxCountDevices(int maxCountDevices) {
        this.maxCountDevices = maxCountDevices;
    }
    public void setRandomFlag(boolean randomFlag) {
        this.randomFlag = randomFlag;
    }
    public void setRepeatFlag(boolean repeatFlag) {
        this.repeatFlag = repeatFlag;
    }
    public void setMaxCountOrders(int maxCountOrders) {
        this.maxCountOrders = maxCountOrders;
    }
    public int getMaxCountDevices() {
        return maxCountDevices;
    }
    public int getMaxCountOrders() {
        return maxCountOrders;
    }

    @Override
    public void run() {
        if (repeatFlag) {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(this.IntervalTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Order new_order = getGenerateOrder();
                if (!(new_order == null)) {
                    this.orders.add(new_order);
                } else {
                    System.out.println("Ошибка генерации Order!");
                }

            }
        } else {
            for (int i = 0; i < maxCountOrders; i++) {
                try {
                    Thread.sleep(this.IntervalTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Order new_order = getGenerateOrder();
                if (!(new_order == null)) {
                    this.orders.add(new_order);
                } else {
                    System.out.println("Ошибка генерации Order!");
                }

            }
        }
    }

    public Order getGenerateOrder() {
        Credentials credentials = GenerateFieldsCredentials();
        LinkedList<Devices> devicesLinkedList = new LinkedList<>();
        if (randomFlag)
            for (int i = 0; i < random.nextInt(maxCountDevices) + 1; i++) {
                Devices device = getRandomDevice();
                if (!(device == null))
                    devicesLinkedList.add(device);
                else
                    System.out.println("Ошибка генерации потомков Devices!");
            }
        else {
            for (int i = 0; i < maxCountDevices; i++) {
                Devices device = getRandomDevice();
                if (!(device == null))
                    devicesLinkedList.add(device);

                else
                    System.out.println("Ошибка генерации потомков Devices!");
            }
        }

        return new Order(new ShoppingCart<Devices>(credentials, devicesLinkedList), 1000 + (long) (new Random().nextDouble() * (100000 - 1000)));

    }

    public void Join() throws InterruptedException {
        if (isRepeatFlag()) {
            this.interrupt();
            super.join();
        } else
            super.join();

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

    public Credentials GenerateFieldsCredentials() {
        return new Credentials(familiesDatabase.getRandomString(), nameDatabase.getRandomString(), otchDatabase.getRandomString(), emailDatabase.getRandomString());
    }
}
