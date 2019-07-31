package ru.eltex.app.java.net;

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
        clientPointer.runListenAlert();
    }
}
