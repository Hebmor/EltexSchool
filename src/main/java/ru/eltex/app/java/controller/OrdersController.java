/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.eltex.app.java.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.eltex.app.java.config.View;
import ru.eltex.app.java.model.shop.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController

public class OrdersController {

    @Autowired
    private ManagerOrderJSON managerOrderJSON;
    @Autowired
    private GeneratorOrders generatorOrders;

    @JsonView(View.Summary.class)
    @RequestMapping
    public Object RequestByCommand(@RequestParam("command") String commandName, @RequestParam(required = false) String order_id, @RequestParam(required = false) String card_id, Model map)
            throws IOException, ClassNotFoundException, SimpleException {

        try {
            if (commandName.equals("readall")) {
                return managerOrderJSON.readAll();
            } else if (commandName.equals("readById")) {
                int id = Integer.parseInt(order_id);
                ArrayList<Order> arrayList = new ArrayList<>();
                arrayList.add(managerOrderJSON.readByID(id));
                return arrayList;
            } else if (commandName.equals("addToCard")) {
                int id = Integer.parseInt(card_id);
                managerOrderJSON.setOrders(new Orders());
                managerOrderJSON.getOrders().setOrdersArrayList(managerOrderJSON.readAll());
                Order addedOrder = generatorOrders.getGenerateOrder();
                addedOrder.setID(id);
                managerOrderJSON.getOrders().add(addedOrder);
                managerOrderJSON.saveAll();
                return id;
            } else if (commandName.equals("delById")) {
                int id = Integer.parseInt(order_id);
                managerOrderJSON.setOrders(new Orders());
                managerOrderJSON.getOrders().setOrdersArrayList(managerOrderJSON.readAll());
                if (managerOrderJSON.getOrders().delete(id)) {
                    managerOrderJSON.saveAll();
                    return 1;
                } else {
                    return 0;
                }
            } else
                throw new SimpleException("Неверная команда!", 3);
        } catch (SimpleException ex) {
            return new String(" " + ex.getMessage() + " ErrorCode: " + ex.getErrorCode());
        }

    }


}
