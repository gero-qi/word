package com.jc.dao;

import java.util.List;

import com.jc.entity.Emp;

public interface EmpDao {
	public void save(Emp emp);
	public void delete(String name);
	public List<Emp> findAll();
	public Emp findByName(String name);
	public void update(Emp emp);
	public List<Emp> findPage(int num);
	public List findRows();

}
