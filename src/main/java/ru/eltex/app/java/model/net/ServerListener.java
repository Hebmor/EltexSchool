package ru.eltex.app.java.model.net;


import ru.eltex.app.java.model.shop.Order;

import java.io.*;
import java.net.*;

public class ServerListener extends Thread {

    private int udpAlertPort = 0;
    private int clientIP = 0;
    private Socket socket;
    private ObjectInputStream in;
    private BufferedWriter out;

    public ServerListener(Socket _socket) throws IOException {
        this.socket = _socket;
        in = new ObjectInputStream(socket.getInputStream());
        this.start();

    }

    @Override
    public void run() {
        Order order = null;

        try {
            System.out.println();
            order = (Order) in.readObject();
            this.udpAlertPort = (int) in.readObject();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(socket.getLocalAddress(),this.udpAlertPort);

            Server.addOrderToOrderMap(inetSocketAddress, order);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


