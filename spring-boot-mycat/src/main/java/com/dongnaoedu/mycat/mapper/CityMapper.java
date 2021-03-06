package com.dongnaoedu.mycat.mapper;

import java.util.List;

import com.dongnaoedu.mycat.model.City;

public interface CityMapper {

	public List<City> selectAll();

	public City selectByPrimaryKey(Integer id);

	public void deleteByPrimaryKey(Integer id);

	public void updateByPrimaryKey(City city);

	public void insert(City city);
}
