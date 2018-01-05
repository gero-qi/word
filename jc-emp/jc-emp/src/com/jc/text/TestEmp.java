package com.jc.text;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jc.entity.tOil;
import com.jc.util.MyBatisUtil;

public class TestEmp {
	public static void main(String[] args){
		SqlSession session=MyBatisUtil.getSqlSession();
		List<tOil> emp=session.selectList("findPage",0);
		for(tOil e:emp){
			System.out.println(e.getId());
		}
//		System.out.println(session);
//		//测试多行查询
//		List<Emp> list=session.selectList("findAll");
//		for(Emp e : list){
//			System.out.println(e.getId());
//		}
		//测试查询一个
//		Emp emp=session.selectOne("findByName","user1");
//		System.out.println(emp.getId());
		
		//添加
//		Emp emp=new Emp();
//		emp.setName("user");
//		emp.setPassword("12345");
//		emp.setAge(25);
//		emp.setSalary(123789);
//		session.insert("save",emp);
//		session.commit();
//		System.out.println(emp.getName());
		
		//删除
//		session.delete("delete","user");
//		session.commit();
//		System.out.println("删除成功");
		
		//修改
//		Emp emp=session.selectOne("findByName","user5");
//	//	System.out.println(emp.getSalary());
//		emp.setName("user05");
//		emp.setPassword("654321");
//		emp.setAge(32);
//		emp.setSalary(55555.0);
//		session.update("update",emp);
//		session.commit();
//		System.out.println(emp.getSalary());
		
	}

}
