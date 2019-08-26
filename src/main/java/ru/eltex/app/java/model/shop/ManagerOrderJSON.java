package ru.eltex.app.java.model.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;
import ru.eltex.app.java.model.products.Devices;
import ru.eltex.app.java.model.products.Phones;
import ru.eltex.app.java.model.products.Smartphones;
import ru.eltex.app.java.model.products.Tablets;

import java.io.*;
import java.util.ArrayList;

@Service
public class ManagerOrderJSON extends AManageOrder {

    private FileWriter fw;
    private FileReader fr;
    private String filePath = "src/main/resources/json/json_data.json";

    private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public ManagerOrderJSON() {
        this.mapper.enableDefaultTyping();

        mapper.registerSubtypes(Phones.class, Devices.class, Smartphones.class, Tablets.class);
    }

    public ManagerOrderJSON(String path, Orders orders) {

        this.setOrders(orders);
        this.mapper.enableDefaultTyping();
        this.filePath = path;
    }

    public ManagerOrderJSON(ObjectMapper mapper) {
        this.mapper = mapper;
        this.mapper.enableDefaultTyping();
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Order readByID(int id) throws SimpleException {

        Order order = SearchOrderByID(id, readAll());
        if (order == null) {
            System.out.println("Ошибка объект с указанным ID не найден!");
            return null;
        } else {
            return order;
        }
    }

    @Override
    public void saveById(int id) throws IOException, SimpleException {
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
    public ArrayList<Order> readAll() throws SimpleException {

        try {
            File yourFile = new File(this.filePath);
            yourFile.createNewFile(); // создать файл если не существует!
            fr = new FileReader(this.filePath);

            if (isFileClear(this.filePath)) {
                File dir1 = new File(this.filePath);
                fr.close();
                return null;
            } else {
                Orders p = mapper.readValue(fr, Orders.class);
                fr.close();
                return p.get_ordersArrayList();
            }
        } catch (IOException ex) {
            throw new SimpleException("Файл поврежден!", 2);
        }

    }

    @Override
    public void saveAll() throws IOException {
        fw = new FileWriter(this.filePath);

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getOrders());
        fw.write(json);
        fw.flush();
        fw.close();
    }

    private boolean isFileClear(String _filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(_filePath));
        return br.readLine() == null;
    }


}
