package com.dn.andemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dn.andemo.annotation.NeedSetFieldValue;
import com.dn.andemo.dao.OrderMapper;
import com.dn.andemo.dao.UserMapper;
import com.dn.andemo.model.Order;
import com.dn.andemo.model.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
//	@Autowired
//	private UserMapper userMapper;

	/**
	 * 查询订单分页
	 * 
	 * @param customerId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@NeedSetFieldValue
	public Page<Order> pageQuery(String customerId, int pageNum, int pageSize) {
		Page<Order> page = PageHelper.startPage(pageNum, pageSize);
		orderMapper.query(customerId);
		
//		for (Order order : page) {
//			User user = userMapper.find(order.getCustomerId());
//			if (user != null) {
//				order.setCustomerName(user.getUserName());
//			}
//		}
		
		return page;
	}

}
