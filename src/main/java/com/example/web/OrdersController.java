package com.example.web;

import com.example.domain.Orders;
import com.example.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DaikiTakeuchi on 2016/11/23.
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    final static Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    OrdersService ordersService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("OrdersController:[index] Passing through...");
        Iterable<Orders> result = ordersService.findAll(1, 10, "id");
        model.addAttribute("result", result);
        return "orders/index";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model) {
        logger.debug("OrdersController:[detail] Passing through...");
        Orders order = ordersService.findById(id);
        model.addAttribute("order", order);
        return "orders/detail";
    }
}
