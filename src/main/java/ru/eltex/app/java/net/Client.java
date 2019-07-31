package ru.eltex.app.java.net;

import ru.eltex.app.java.shop.GeneratorOrders;

import java.io.*;
import java.net.*;

public class Client {

    private GeneratorOrders generatorOrders = new GeneratorOrders();

    private int socketPort = 1667;
    private int OrderAlertPort = 1668;


    public void runListenAlert() {
        try {
            MulticastSocket udpSocket = new MulticastSocket(socketPort);
            InetAddress IP = InetAddress.getByName("224.0.0.1");
            udpSocket.joinGroup(IP);

            String serverWord = "";
            byte[] buffer = new byte[65536];
            byte[] buffer2 = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
            DatagramSocket datagramSocket = new DatagramSocket(5757);
            DatagramSocket udpOrderAlertSocket = new DatagramSocket(5555);
            System.out.println("Ожидаем данные...");

            //Получаем данные
            udpSocket.receive(incoming);
            udpSocket.close();
            byte[] data = incoming.getData();
            String s = new String(data, 0, incoming.getLength());
            InetAddress IPAddress = incoming.getAddress();
            int port = incoming.getPort();
            System.out.println("Клиент получил: " + " TCP порт:" + s + " IP: " + IPAddress.toString() + ":" + port);


            DatagramPacket alert_packet = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(alert_packet);


        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void stateLIstenTCPport() {

    }


}
