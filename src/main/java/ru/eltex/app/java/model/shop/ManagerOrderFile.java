package ru.eltex.app.java.model.shop;

import java.io.*;
import java.util.ArrayList;


public class ManagerOrderFile extends AManageOrder {

    private FileOutputStream outputStream;
    private FileInputStream fileInputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    private String filePath = "src/main/resources/binary_date/data.dat";

    private ArrayList<Order> bufferArrayList = new ArrayList<>();

    public ManagerOrderFile() throws FileNotFoundException {
        outputStream = new FileOutputStream(this.filePath);
        fileInputStream = new FileInputStream(this.filePath);
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectInputStream = new ObjectInputStream(fileInputStream);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ManagerOrderFile(String path) throws FileNotFoundException {
        this.filePath = path;
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
    public Order readByID(int id) {

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
    public ArrayList<Order> readAll() {
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
