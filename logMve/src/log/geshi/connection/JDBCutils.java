package log.geshi.connection;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class JDBCutils {
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;
	
	static{
		try{
			InputStream in = JDBCutils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties pro = new Properties();
			pro.load(in);
			driver = pro.getProperty(driver);
			url = pro.getProperty(url);
			username = pro.getProperty(username);
			password = pro.getProperty(password);
			Class.forName(driver);
		}catch( Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	public static Connection getConnection() throws Exception{
		return   (Connection) DriverManager.getConnection(url, username, password);
	}
	
	public static void release(Connection conn, Statement st,ResultSet rs){
		if(rs!=null){
			try{
				rs.close();
			}catch (Exception e){
				e.printStackTrace();
			}
			rs = null;
		}
		if(st!=null){
			try{
				st.close();
			}catch (Exception e){
				e.printStackTrace();
			}
			st = null;
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}
