package ru.eltex.app.java.model.net;

import ru.eltex.app.java.model.shop.Order;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Map;

public class CheckOrderThread extends Thread {

    private long interval = 0;

    public CheckOrderThread(long interval) {
        this.interval = interval;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                sleep(interval);
                checkOrderByUDP_Port();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    private synchronized void checkOrderByUDP_Port() throws IOException {
        DatagramSocket datagramSocket;
        datagramSocket = new DatagramSocket();
        byte[] buffer = new byte[65536];
        long remainingTime = 0;

        if (Server.ordersMap.size() != 0)
            for (Map.Entry<Integer, Order> entry : Server.ordersMap.entrySet()) {
                remainingTime = entry.getValue().getRemainingTime();
                if (remainingTime > 0) {
                    System.out.println("Заказ: " + entry.getValue().getID() + " по порту UDP: " + entry.getKey() + " / до обработки заказа осталось: " + entry.getValue().getRemainingTime() + " ms ");
                }
                if (entry.getValue().getState() == Order.stateWork.PROCESSED) {
                    buffer = String.valueOf(entry.getValue().getID()).getBytes();
                    DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), entry.getKey());
                    datagramSocket.send(datagramPacket);
                }
            }
    }
}
