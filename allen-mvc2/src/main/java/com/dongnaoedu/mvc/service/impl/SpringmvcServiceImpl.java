package com.dongnaoedu.mvc.service.impl;

import java.util.Map;

import com.dongnaoedu.mvc.annotation.Service;
import com.dongnaoedu.mvc.service.SpringmvcService;

@Service("SpringmvcServiceImpl")
public class SpringmvcServiceImpl implements SpringmvcService{
    @Override
    public int insert(Map map) {
        System.out.println("SpringmvcServiceImpl:" + "insert");
        return 0;
    }
    @Override
    public int delete(Map map) {
        System.out.println("SpringmvcServiceImpl:" + "delete");
        return 0;
    }
    @Override
    public int update(Map map) {
        System.out.println("SpringmvcServiceImpl:" + "update");
        return 0;
    }
    @Override
    public int select(Map map) {
        System.out.println("SpringmvcServiceImpl:" + "select");
        return 0;
    }

}