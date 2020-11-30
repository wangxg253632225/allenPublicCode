package com.dongnaoedu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongnaoedu.service.IOrderService;
import com.dongnaoedu.utils.SnowflakeIdWorker;

/**
 * 订单号-Twitter_Snowflake实现
 * 
 * @author allen
 *
 */
@Service("snowflakeOrderServiceImpl")
public class SnowflakeOrderServiceImpl implements IOrderService {

	@Autowired
	private SnowflakeIdWorker snowflakeIdWorker;
	
	/**
	 * 产生订单号
	 */
	@Override
    public void orderId() {
		System.out.println("insert into order_id(id) values('" + snowflakeIdWorker.nextId() + "');");
	}
	
}
