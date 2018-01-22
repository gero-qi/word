package com.jc.dao;

import java.util.List;
import java.util.Map;

import com.jc.entity.tOil;



public interface tOilDao {
	//增
	void save(tOil oil);
	//删
	void delete(String name);
	//查所有
	List<tOil> findAll();
	//查
	tOil findByName(String name);
	//查
	tOil findById(int id);
	//改
	void update(tOil oil);
	//分页
	List<tOil> findPage(int num);
	int findRows();
	//分页
	List<tOil> findIds(String name);
	
	int findCount(String string);
	
	 List<tOil> findAll(String string);
	 
	 List<User> findUserPasswordByName(String name);
	 
	 void updateID(int id);
	 
	 List<Object> findAllUser();
}
