package ru.eltex.app.java.model.shop;

import java.io.IOException;
import java.util.ArrayList;


public interface IOrder {
    Order readByID(int id) throws IOException, ClassNotFoundException, SimpleException;

    void saveById(int id) throws IOException, ClassNotFoundException, SimpleException;

    ArrayList<Order> readAll() throws IOException, ClassNotFoundException, SimpleException;

    void saveAll() throws IOException;

}
