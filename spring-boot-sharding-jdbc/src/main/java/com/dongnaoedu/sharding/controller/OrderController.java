package com.dongnaoedu.sharding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongnaoedu.sharding.model.OrderItem;
import com.dongnaoedu.sharding.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping
    @ResponseBody
    public List<OrderItem> getAll(OrderItem order) {
        List<OrderItem> orderList = orderService.getAllByWeekend(order);
        return orderList;
    }
}
