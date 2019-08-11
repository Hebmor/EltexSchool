package ru.eltex.app.java.dao;

import ru.eltex.app.java.model.products.Devices;

import java.util.List;
import java.util.UUID;

public interface DAO {
    Devices findById(int id);

    void save(Devices devices);

    void update(Devices devices);

    void delete(Devices devices);

    Devices findDeviceById(int id);

    Devices findDeviceByUUID(UUID id);

    List<Devices> findAll();
}
