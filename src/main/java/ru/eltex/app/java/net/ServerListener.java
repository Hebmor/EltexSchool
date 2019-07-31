package ru.eltex.app.java.net;

import ru.eltex.app.java.shop.Order;

import java.io.*;
import java.net.Socket;

public class ServerListener extends Thread {

    private Socket socket;
    private InputStream inputStream;
    private ObjectInputStream in;
    private BufferedWriter out;


    static int beginPort = 5000;
    int currectPort = 0;

    public ServerListener(Socket _socket) throws IOException {
        this.socket = _socket;
        inputStream = socket.getInputStream();
        in = new ObjectInputStream(inputStream);
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        this.start();

    }

    @Override
    public void run() {
        Order order = null;
        while (!socket.isClosed()) {
            try {

                order = (Order) in.readObject();
                this.currectPort = getFreePort();
                out.write(String.valueOf(currectPort));
                out.flush();
                System.out.println(this.getId());
                System.out.println(socket.getPort());

                //order.showOrder();
                Server.addOrderToOrderMap(order, socket.getLocalPort());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally { // в любом случае сокет будет закрыт
                ;
                try {
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public int getFreePort() {
        return beginPort + 1;
    }
}
