package ru.eltex.app.java.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ManagerOrderJSON extends AManageOrder {
    FileWriter fw;
    FileReader fr;
    StringWriter writer = new StringWriter();
    StringWriter reader;
    byte[] jsonData;
    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);


    public ManagerOrderJSON(String path, Orders orders) throws IOException {
        fw = new FileWriter(path);
        fr = new FileReader(path);
        jsonData = Files.readAllBytes(Paths.get(path));
        this.setOrders(orders);
        mapper.enableDefaultTyping();
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

        return null;
    }

    @Override
    public void saveById(int id) throws IOException {

    }

    @Override
    public ArrayList<Order> readAll() throws IOException, ClassNotFoundException {

        Orders p = mapper.readValue(fr, Orders.class);
        return p.get_ordersArrayList();

    }

    @Override
    public void saveAll() throws IOException {
        //Запись в форматированном виде!
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getOrders());
        fw.write(json);
        fw.flush();
        fw.close();


    }
}
