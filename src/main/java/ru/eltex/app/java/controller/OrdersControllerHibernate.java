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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.app.java.config.View;
import ru.eltex.app.java.hibernate.DevicesService;
import ru.eltex.app.java.model.shop.GeneratorOrders;
import ru.eltex.app.java.model.shop.Order;
import ru.eltex.app.java.model.shop.SimpleException;

import java.io.IOException;


@RestController
public class OrdersControllerHibernate {

    @Autowired
    private GeneratorOrders generatorOrders;
    @Autowired
    private DevicesService devicesService;

    @JsonView(View.Summary.class)
    @RequestMapping
    public Object RequestByCommand(@RequestParam("command") String commandName, @RequestParam(required = false) String order_id, @RequestParam(required = false) String card_id, Model map)
            throws IOException, ClassNotFoundException, SimpleException {

        try {
            if (commandName.equals("readall")) {
                return devicesService.findAllOrder();
            } else if (commandName.equals("readById")) {
                int id = Integer.parseInt(order_id);
                return devicesService.findOrderById(id);
            } else if (commandName.equals("addToCard")) {
                int id = Integer.parseInt(card_id);

                if (devicesService.findOrderById(id) == null) {
                    Order addedOrder = generatorOrders.getGenerateOrder();
                    addedOrder.setID(id);
                    devicesService.saveOrder(addedOrder);
                    return id;
                } else {
                    return new String("Ошибка объект с таким ID существует!");
                }
            } else if (commandName.equals("delById")) {
                int id = Integer.parseInt(order_id);
                if (devicesService.deleteDevice(id)) {
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
