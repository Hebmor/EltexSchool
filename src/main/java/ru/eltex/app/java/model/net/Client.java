package ru.eltex.app.java.model.net;

import ru.eltex.app.java.model.shop.GeneratorOrders;

import java.io.*;
import java.net.*;

public class Client {


    private static GeneratorOrders generatorOrders = new GeneratorOrders();
    private static int countClients = 0;
    private int multicastServerPort = 1667;
    private Socket clientTcpSocket;
    private DatagramSocket multicastSocket;
    private ObjectOutputStream tcpOut;
    private StringBuilder multicastIP = new StringBuilder("224.0.0.1");
    private int ID = 0;

    public Client() {
        countClients++;
        this.ID = countClients;
    }

    public Client(StringBuilder multicastIP, int multicastServerPort) {
        this.multicastServerPort = multicastServerPort;
        this.multicastIP = multicastIP;
    }

    public void runClient() throws IOException {
        int port = listenMulticastServer();
        if (port != 0) {
            do {

                sendTcpPacket(port);

            } while (checkAlertReceive());
        } else {
            System.out.println("Ошибка получения порта!");
        }

    }

    private int listenMulticastServer() {
        try {
            MulticastSocket udpSocket = new MulticastSocket(multicastServerPort);
            InetAddress IP = InetAddress.getByName(multicastIP.toString());
            multicastSocket = new DatagramSocket(0);
            byte[] buffer = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            udpSocket.joinGroup(IP);

            System.out.println("Клиент ID: " + this.ID + " Ожидает получение адреса для подключения к серверу...");

            udpSocket.receive(incoming);
            udpSocket.close();

            byte[] data = incoming.getData();
            String tcpPort = new String(data, 0, incoming.getLength());
            InetAddress IPAddress = incoming.getAddress();
            System.out.println("Клиент ID: " + this.ID + " получил: " + " IP/port: " + IPAddress.toString() + "|" + " TCP порт:" + tcpPort);
            return Integer.parseInt(tcpPort);

        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return 0;


    }

    private void sendTcpPacket(int port) throws IOException {


        clientTcpSocket = new Socket("localhost", port);

        try {
            tcpOut = new ObjectOutputStream(clientTcpSocket.getOutputStream());
            tcpOut.writeObject(generatorOrders.getGenerateOrder());
            tcpOut.writeObject(multicastSocket.getLocalPort());
            tcpOut.flush();
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        } finally {
            clientTcpSocket.close();
            tcpOut.close();
        }
    }

    private boolean checkAlertReceive() throws IOException {
        byte[] buffer = new byte[100];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        multicastSocket.receive(dp);

        byte[] id = dp.getData();
        String sId = new String(id, 0, dp.getLength());
        System.out.println("Заказ ID: " + sId + " Обработан!");
        return true;
    }

}


