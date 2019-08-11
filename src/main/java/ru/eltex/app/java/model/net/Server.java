package ru.eltex.app.java.model.net;

import ru.eltex.app.java.model.shop.Order;
import ru.eltex.app.java.model.shop.Orders;
import ru.eltex.app.java.model.shop.PendingCheck;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    static public boolean checkFlag = false;
    static HashMap<Integer, Order> ordersMap = new HashMap<Integer, Order>();
    private static PendingCheck pendingCheck;
    private ArrayList<ServerListener> tcpSocketClientCollection = new ArrayList<>();
    private int broadcastUDP_Port = 1667;
    private int TCP_Port;
    private ServerSocket tcpSocket = new ServerSocket(0);
    private CheckOrderThread checkOrderThread;

    public Server() throws IOException {
    }

    static public void addOrderToOrderMap(int socketPort, Order order) {
        ordersMap.put(socketPort, order);
        updatePendingCheck(pendingCheck);
    }

    static private void runPendingCheck() {

        ArrayList<Order> arrayList = new ArrayList<>(ordersMap.values());

        pendingCheck = new PendingCheck("PendingThread", new Orders(arrayList), 1000);

        if (arrayList != null && !checkFlag) {
            pendingCheck.start();
            checkFlag = true;

        }
    }

    private synchronized static void updatePendingCheck(PendingCheck pendingCheck) {
        pendingCheck.setArrayListToOrders(new ArrayList<>(ordersMap.values()));
    }

    public int getBroadcastUDP_Port() {
        return broadcastUDP_Port;
    }

    public void setBroadcastUDP_Port(int broadcastUDP_Port) {
        this.broadcastUDP_Port = broadcastUDP_Port;
    }

    public int getTCP_Port() {
        return TCP_Port;
    }

    public void setTCP_Port(int TCP_Port) {
        this.TCP_Port = TCP_Port;
    }

    public void Connection() {

    }

    public void runServer() {

        checkOrderThread = new CheckOrderThread(1000);
        Runnable checkTask = new Runnable() {
            @Override
            public void run() {
                checkOrderThread.start();
                runPendingCheck();

            }
        };
        Thread thread = new Thread(checkTask);
        thread.start();
        try {
            broadcastTcpPortByUDP();
            listenTcpPort();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void broadcastTcpPortByUDP() throws IOException {
        MulticastSocket udpSocketMulticast = new MulticastSocket(broadcastUDP_Port);
        InetAddress IPAddress = InetAddress.getByName("224.0.0.1");
        udpSocketMulticast.joinGroup(IPAddress);
        byte[] sendData = String.valueOf(tcpSocket.getLocalPort()).getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, broadcastUDP_Port);
        System.out.println("Отправляем TCP порт клиентам по ..." + IPAddress.toString());
        udpSocketMulticast.send(sendPacket);

    }

    private void listenTcpPort() throws IOException {
        while (true) {
            Socket clientSocket = tcpSocket.accept();
            readTcpPort(clientSocket);

        }
    }

    private void readTcpPort(Socket clientSocket) throws IOException {
        ServerListener serverListener = new ServerListener(clientSocket);

    }

    public void TCPListener() {

    }


}


