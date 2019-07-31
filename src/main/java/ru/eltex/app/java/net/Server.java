package ru.eltex.app.java.net;

import ru.eltex.app.java.shop.Order;
import ru.eltex.app.java.shop.Orders;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Server {

    private ArrayList<ServerListener> tcpSocketClientCollection = new ArrayList<>();
    static private Orders orders;
    static Map<Integer, Orders> orderMap = new Map<Integer, Orders>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object o) {
            return false;
        }

        @Override
        public boolean containsValue(Object o) {
            return false;
        }

        @Override
        public Orders get(Object o) {
            return null;
        }


        @Override
        public Orders put(Integer integer, Orders orders) {
            return null;
        }

        @Override
        public Orders remove(Object o) {
            return null;
        }

        @Override
        public void putAll(Map<? extends Integer, ? extends Orders> map) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<Integer> keySet() {
            return null;
        }

        @Override
        public Collection<Orders> values() {
            return null;
        }

        @Override
        public Set<Entry<Integer, Orders>> entrySet() {
            return null;
        }

    };
    private String socketUDPPort = "1667";

    public void Connection() {

    }

    public void UPDLocalAlert() throws IOException, ClassNotFoundException {

        MulticastSocket udpSocketMulticast = new MulticastSocket(Integer.parseInt(socketUDPPort));
        InetAddress IPAddress = InetAddress.getByName("224.0.0.1");
        InetAddress IPlocal = InetAddress.getByName("localhost");
        udpSocketMulticast.joinGroup(IPAddress);
        DatagramSocket alertSocket = new DatagramSocket();
        ServerSocket tcpSocket = new ServerSocket(0);
        byte[] sendData = String.valueOf(tcpSocket.getLocalPort()).getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(socketUDPPort));
        System.out.println("Отправляем данные...");
        udpSocketMulticast.send(sendPacket);


        DatagramPacket packet = new DatagramPacket(sendData, sendData.length, IPlocal, 5757);
        alertSocket.send(packet);


    }

    public void TCPListener() {

    }

    static public void addOrderToOrderMap(Order order, int socketPort) {
        if (orderMap.containsKey(socketPort)) {
            orderMap.get(socketPort).add(order);
        } else {
            orderMap.put(socketPort, new Orders(order));
        }

    }

}
