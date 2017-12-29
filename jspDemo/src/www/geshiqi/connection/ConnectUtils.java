package www.geshiqi.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectUtils {

		private static String password = null;
		private static String url = null;
		private static String name = null;
		private static String driver = null;
		static{	
			
		try{
				InputStream in = ConnectUtils.class.getClassLoader().getResourceAsStream("db1.properties");
				
				Properties prop = new Properties();
				prop.load(in);
				driver = prop.getProperty("driver");
				url = prop.getProperty("url");
				name = prop.getProperty("name");
				password = prop.getProperty("password");
				Class.forName(driver);
				System.out.println(url);
				System.out.println(driver);
				System.out.println(name);
				System.out.println(password);
			}catch (Exception e){
				throw new ExceptionInInitializerError(e);
			}
		}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,name,password);
	}
		
	public static void release(Connection conn ,Statement st,ResultSet rs) throws SQLException{
		if(rs!=null){
			rs.close();
			rs=null;
		}
		if(st!=null){
			st.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	
}
