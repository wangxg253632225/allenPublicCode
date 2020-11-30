package com.dongnaoedu.sharding.mapper;

import com.dongnaoedu.sharding.model.Order;

public interface OrderMapper {
    
    void createIfNotExistsTable();
    
    void truncateTable();
    
    Long insert_o(Order model);
    
    void delete_o(Long orderId);
    
    void dropTable();
}
