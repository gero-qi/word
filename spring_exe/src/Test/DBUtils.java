package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

 

public class DBUtils {
	public static String driverClass="com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3305/ee19_crmdb";
	public static String pass="root";
	public static String user="root";
	static{
	try{
		Class.forName(driverClass);
	}catch (ClassNotFoundException e){
		e.printStackTrace();
	}
	}
	
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,pass);
	}
	public static void closeAll(ResultSet rs,Statement stmt,Connection con) throws SQLException{
		if(rs!=null){
			try{rs.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			stmt.close();
		}
		if(con!=null){
			con.close();
		}
		con=null;
	}

}

