package ru.eltex.app.java.net;

import java.io.IOException;

public class ServerThread implements Runnable {
    Server serverPointer;

    public ServerThread(Server serverPointer) {
        this.serverPointer = serverPointer;
    }

    public Server getServerPointer() {
        return serverPointer;
    }

    public void setServerPointer(Server serverPointer) {
        this.serverPointer = serverPointer;
    }

    @Override
    public void run() {
        try {
            serverPointer.UPDLocalAlert();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
