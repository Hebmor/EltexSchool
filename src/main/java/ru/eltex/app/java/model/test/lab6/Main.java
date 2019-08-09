package ru.eltex.app.java.model.test.lab6;

import ru.eltex.app.java.model.net.Client;
import ru.eltex.app.java.model.net.ClientThread;
import ru.eltex.app.java.model.net.Server;
import ru.eltex.app.java.model.net.ServerThread;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        TestNetwork();
    }

    public static void TestNetwork() throws IOException {
        ClientThread clientThread = new ClientThread(new Client());
        ClientThread clientThread2 = new ClientThread(new Client());
        ClientThread clientThread3 = new ClientThread(new Client());
        ClientThread clientThread4 = new ClientThread(new Client());


        ServerThread serverHandler = new ServerThread(new Server());

        Thread threadClient = new Thread(clientThread);
        Thread threadClient2 = new Thread(clientThread2);
        Thread threadClient3 = new Thread(clientThread3);
        Thread threadClient4 = new Thread(clientThread4);
        Thread threadServer = new Thread(serverHandler);

        threadServer.start();
        threadClient.start();
        threadClient2.start();
        threadClient3.start();
        threadClient4.start();
    }

}
