package ru.eltex.app.java.shop;

import ru.eltex.app.java.products.Devices;

import java.io.IOException;
import java.util.ArrayList;


public interface IOrder {
    Order readByID(int id) throws IOException, ClassNotFoundException;

    void saveById(int id) throws IOException;

    ArrayList<Devices> readAll() throws IOException, ClassNotFoundException;

    void saveAll() throws IOException;

}
