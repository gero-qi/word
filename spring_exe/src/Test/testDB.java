package Test;

import java.sql.SQLException;

public class testDB {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
/* 		PerSonSchema per = new PerSonSchema();
		per.setId("1");
		per.setName("wangzhenpeng");*/
/*		PersonDB testdb = new PersonDB();
		if(testdb.inset(per)){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");; 
		}*/
		
	/*	PersonDB testdb = new PersonDB();
		if(testdb.update(per)){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");; 
		}*/
		PersonDB testdb = new PersonDB();
 
		System.out.println(testdb.getById("1"));
	 
		 
	}

}
