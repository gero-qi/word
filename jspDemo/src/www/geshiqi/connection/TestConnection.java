package www.geshiqi.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestConnection {
	
	@Test
	public void insert() throws SQLException{
		Connection conn = ConnectUtils.getConnection();
		Statement st= conn.createStatement();
	 
		 
		int num = st.executeUpdate("insert into users(name,password,email,birthday) values('°×»¢Éñ»Ê','123','bhsh@sina.com','1980-09-09')");
		
			System.out.println(num);
		
	}
}
