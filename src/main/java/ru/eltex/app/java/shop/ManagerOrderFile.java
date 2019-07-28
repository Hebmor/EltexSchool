package ru.eltex.app.java.shop;

import java.io.*;
import java.util.ArrayList;

public class ManagerOrderFile extends AManageOrder {

    FileOutputStream outputStream;
    FileInputStream fileInputStream;

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    private ArrayList<Order> bufferArrayList = new ArrayList<>();

    public ManagerOrderFile(String path) throws FileNotFoundException {
        outputStream = new FileOutputStream(path);
        fileInputStream = new FileInputStream(path);
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(fileInputStream);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ManagerOrderFile(String path, Orders orders) throws FileNotFoundException {
        outputStream = new FileOutputStream(path);
        fileInputStream = new FileInputStream(path);
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(fileInputStream);


        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setOrders(orders);
    }

    @Override
    public Order readByID(int id) throws IOException, ClassNotFoundException {

        return SearchOrderByID(id, getOrders().get_ordersArrayList());
    }

    @Override
    public void saveById(int id) throws IOException {
        objectInputStream.reset();
        objectOutputStream.writeObject(SearchOrderByID(id, getOrders().get_ordersArrayList()));
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @Override
    public ArrayList<Order> readAll() throws IOException, ClassNotFoundException {
        try {
            if (objectInputStream.available() == 0) {
                bufferArrayList = (ArrayList<Order>) objectInputStream.readObject();
                return bufferArrayList;
            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return bufferArrayList;
    }

    @Override
    public void saveAll() throws IOException {

        objectOutputStream.writeObject(this.getOrders().get_ordersArrayList());
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}
