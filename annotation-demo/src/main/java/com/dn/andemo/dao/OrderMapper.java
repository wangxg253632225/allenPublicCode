package com.dn.andemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dn.andemo.model.Order;

@Mapper
@CacheNamespace
public interface OrderMapper {

	List<Order> query(@Param("customerId") String customerId);
}
