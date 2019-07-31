package ru.eltex.app.java.lab6;


import ru.eltex.app.java.net.Client;
import ru.eltex.app.java.net.ClientThread;
import ru.eltex.app.java.net.Server;
import ru.eltex.app.java.net.ServerThread;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        TestNetwork();
    }

    public static void TestNetwork() throws IOException {
        ClientThread clientThread = new ClientThread(new Client());
        // ClientHandler clientHandler2 = new ClientHandler(new Client());
        ServerThread serverHandler = new ServerThread(new Server());

        Thread thread = new Thread(clientThread);
        Thread thread2 = new Thread(serverHandler);
        //Thread thread3 = new Thread(clientHandler2);

        thread2.start();
        thread.start();
        //thread3.start();


    }


}
