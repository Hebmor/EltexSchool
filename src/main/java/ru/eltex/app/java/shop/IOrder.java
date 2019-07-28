package ru.eltex.app.java.shop;

import java.io.IOException;
import java.util.ArrayList;


public interface IOrder {
    Order readByID(int id) throws IOException, ClassNotFoundException;

    void saveById(int id) throws IOException, ClassNotFoundException;

    ArrayList<Order> readAll() throws IOException, ClassNotFoundException;

    void saveAll() throws IOException;

}
