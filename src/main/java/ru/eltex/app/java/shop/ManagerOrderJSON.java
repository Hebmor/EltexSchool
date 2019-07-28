package ru.eltex.app.java.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;


public class ManagerOrderJSON extends AManageOrder {

    private FileWriter fw;
    private FileReader fr;
    private String filePath;
    private StringWriter writer = new StringWriter();

    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);


    public ManagerOrderJSON(String path, Orders orders) throws IOException {

        this.setOrders(orders);
        this.mapper.enableDefaultTyping();
        this.filePath = path;
    }

    public ManagerOrderJSON(StringWriter writer, ObjectMapper mapper) throws IOException {
        this.writer = writer;
        this.mapper = mapper;
    }

    public StringWriter getWriter() {
        return writer;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public void setWriter(StringWriter writer) {
        this.writer = writer;
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Order readByID(int id) throws IOException, ClassNotFoundException {

        Order order = SearchOrderByID(id, readAll());
        if (order == null) {
            System.out.println("Ошибка объект с указанным ID не найден!");
            return null;
        } else {
            return order;
        }
    }

    @Override
    public void saveById(int id) throws IOException, ClassNotFoundException {
        Orders read_orders = new Orders();
        ArrayList<Order> orderArrayList = readAll();
        Order idOrder = SearchOrderByID(id, getOrders().get_ordersArrayList());
        if (orderArrayList != null) {
            read_orders.setOrdersArrayList(orderArrayList);
        }
        if (idOrder != null) {
            read_orders.add(idOrder);
        } else {
            System.out.println("Ошибка элемента с таким ID не существует!");
            return;
        }
        fw = new FileWriter(this.filePath);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(read_orders);
        fw.write(json);
        fw.flush();
        fw.close();
    }

    @Override
    public ArrayList<Order> readAll() throws IOException, ClassNotFoundException {

        fr = new FileReader(this.filePath);
        if (isFileClear(this.filePath)) {
            return null;
        } else {
            Orders p = mapper.readValue(fr, Orders.class);
            fr.close();
            return p.get_ordersArrayList();
        }
    }

    @Override
    public void saveAll() throws IOException {
        fw = new FileWriter(this.filePath);

        //Запись в форматированном виде!
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getOrders());
        fw.write(json);
        fw.flush();
        fw.close();
    }

    private boolean isFileClear(String _filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(_filePath));
        if (br.readLine() == null) {
            return true;
        } else
            return false;
    }


}
