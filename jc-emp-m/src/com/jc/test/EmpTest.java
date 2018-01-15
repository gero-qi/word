package com.jc.test;

import java.util.List;

import org.junit.Test;

import com.jc.dao.EmpDao;
import com.jc.entity.Emp;

public class EmpTest extends TestBasic{
//	@Test
	public void findAll(){
		EmpDao empDao=getContext().getBean("empDao",EmpDao.class);
		List<Emp> list=empDao.findAll();
		for(Emp e : list){
			System.out.println(e.getId());
		}
	}
//	@Test
	public void findByName(){
		EmpDao empDao=getContext().getBean("empDao",EmpDao.class);
		Emp emp=empDao.findByName("user1");
		System.out.println(emp.getName());
	}
//	@Test
	public void save(){
		EmpDao empDao=getContext().getBean("empDao",EmpDao.class);
		Emp emp=new Emp();
		emp.setName("��ҵ");
		emp.setAge(42);
		emp.setJob("programmer");
		empDao.save(emp);
		System.out.println("����ɹ�");
	}
//	@Test
	public void update(){
		EmpDao empDao=getContext().getBean("empDao",EmpDao.class);
		Emp emp=empDao.findByName("��ҵ");
		emp.setAge(34);
		empDao.update(emp);
		System.out.println("�޸ĳɹ�");
	}
//	@Test
	public void delete(){
		EmpDao empDao=getContext().getBean("empDao",EmpDao.class);
		empDao.delete("��ҵ");
		System.out.println("ɾ���ɹ�");
	}
}
