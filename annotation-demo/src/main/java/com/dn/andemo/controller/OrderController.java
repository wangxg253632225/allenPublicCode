package com.dn.andemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dn.andemo.service.OrderService;
import com.dn.andemo.util.BeanUtil;

@RestController()
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private BeanUtil beanUtil;

	// http://localhost:8080/order/query?pageNum=1&pageSize=5
	@RequestMapping("query")
	public Object query(String customerId, int pageNum, int pageSize) {
		return this.orderService.pageQuery(customerId, pageNum, pageSize);

	}
}
