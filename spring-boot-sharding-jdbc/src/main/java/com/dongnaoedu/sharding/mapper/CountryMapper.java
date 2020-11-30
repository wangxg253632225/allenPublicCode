package com.dongnaoedu.sharding.mapper;

import org.apache.ibatis.annotations.Select;

import com.dongnaoedu.sharding.model.Country;
import com.dongnaoedu.sharding.util.MyMapper;

public interface CountryMapper extends MyMapper<Country> {

    @Select("select * from country limit 1")
    Country findOne();
}