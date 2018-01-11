package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import school.Classes;

import domain.User;

public class Test1 {
/* @Test
 public void testGetUser(){
	 SqlSession  session = MyBatisUtil.getSession();
	 String statement = "mapping.connect.getUser";
	 List<User> user = session.selectList(statement);
	 session.close();
	 System.out.println(user.get(0));
 }
 
  @Test
 public void testGetUser1(){
	 SqlSession  session = MyBatisUtil.getSession();
	 String statement = "mapping.connect.getUser1";
	 List<User> user = session.selectList(statement,1);
	 session.close();
	 System.out.println(user.get(0));
 } */
  @Test
  public void testClass(){
	  SqlSession session = MyBatisUtil.getSession();
	  String statement = "mapping.schoolMapping.getClass1";
	  Classes classes = session.selectOne(statement,2);
	  session.close();
	  System.out.println(classes);
  }
}
