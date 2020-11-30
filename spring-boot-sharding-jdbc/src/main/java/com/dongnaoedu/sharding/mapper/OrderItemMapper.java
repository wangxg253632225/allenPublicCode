package com.dongnaoedu.sharding.mapper;

import java.util.List;

import com.dongnaoedu.sharding.model.OrderItem;
import com.dongnaoedu.sharding.util.MyMapper;

public interface OrderItemMapper extends MyMapper<OrderItem> {
    
    void createIfNotExistsTable();
    
    void truncateTable();
    
    Long insert_oi(OrderItem model);
    
    void delete_oi(Long orderItemId);
    
    List<OrderItem> selectAll_oi();
    
    void dropTable();
}
