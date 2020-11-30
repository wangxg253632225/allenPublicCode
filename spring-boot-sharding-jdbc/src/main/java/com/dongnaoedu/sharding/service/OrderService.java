package com.dongnaoedu.sharding.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongnaoedu.sharding.mapper.OrderItemMapper;
import com.dongnaoedu.sharding.mapper.OrderMapper;
import com.dongnaoedu.sharding.model.Country;
import com.dongnaoedu.sharding.model.Order;
import com.dongnaoedu.sharding.model.OrderItem;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

@Service
public class OrderService {
    
    @Resource
    private OrderMapper orderMapper;
    
    @Resource
    private OrderItemMapper orderItemMapper;
    
    public List<OrderItem> getAllByWeekend(OrderItem orderItem) {
        if (orderItem.getPage() != null && orderItem.getRows() != null) {
            PageHelper.startPage(orderItem.getPage(), orderItem.getRows());
        }
        Weekend<OrderItem> weekend = Weekend.of(OrderItem.class);
        return orderItemMapper.selectByExample(weekend);
    }
    
    public void demo() {
    	orderMapper.createIfNotExistsTable();
    	orderItemMapper.createIfNotExistsTable();
        orderMapper.truncateTable();
        orderItemMapper.truncateTable();
        List<Long> orderIds = new ArrayList<>(10);
        System.out.println("1.Insert--------------");
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(51);
            order.setStatus("INSERT_TEST");
            orderMapper.insert_o(order);
            long orderId = order.getOrderId();
            orderIds.add(orderId);
            
            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(51);
            orderItemMapper.insert_oi(item);
        }
        System.out.println(orderItemMapper.selectAll_oi());
        /*
        System.out.println("2.Delete--------------");
        for (Long each : orderIds) {
            orderRepository.delete_o(each);
            orderItemRepository.delete_oi(each);
        }
        System.out.println(orderItemRepository.selectAll_oi());
        orderItemRepository.dropTable();
        orderRepository.dropTable();
        */
    }
    
}
