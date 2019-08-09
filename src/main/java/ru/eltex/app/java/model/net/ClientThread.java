package ru.eltex.app.java.model.net;

import java.io.IOException;

public class ClientThread implements Runnable {
    Client clientPointer;

    public ClientThread(Client clientPointer) {
        this.clientPointer = clientPointer;
    }

    public Client getClientPointer() {
        return clientPointer;
    }

    public void setClientPointer(Client clientPointer) {
        this.clientPointer = clientPointer;
    }

    @Override
    public void run() {
        try {
            clientPointer.runClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
