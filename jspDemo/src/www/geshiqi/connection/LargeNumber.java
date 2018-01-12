package www.geshiqi.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

public class LargeNumber {

/*	@Test
	public void add() throws SQLException{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		InputStreamReader reader = null;
	try{
		conn = ConnectUtils.getConnection();
		String sql = "insert into testclob(resume) values(?)";
		st = (PreparedStatement) conn.prepareStatement(sql);
		//获取文件路径
		String path = LargeNumber.class.getClassLoader().getResource("data.txt").getPath();
		System.out.println(path);
		path = path.replaceAll("%20", "");
		//创建file对象
		File file  = new File(path);
		
		//reader  file对象
		reader = new InputStreamReader(new FileInputStream(file), "UTF-8");  
		
		st.setCharacterStream(1, reader,(int) file.length());
		int num = st.executeUpdate();
		if(num>0){
			System.out.println("插入成功");
		}
		reader.close();
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		ConnectUtils.release(conn, st, rs);
	}
	}
	@Test
	public void read() throws SQLException{
		Connection conn =null;
		PreparedStatement st =null;
		ResultSet rs=null;
		try{
			conn = ConnectUtils.getConnection();
			String sql = "select resume from testclob where id=2";
			st = (PreparedStatement) conn.prepareStatement(sql);
			rs = st.executeQuery();
			String contentStr="";
			String content="";
			
			if(rs.next()){
				content = new String(rs.getString("resume").getBytes("utf-8"),"utf-8");
				Reader reader = rs.getCharacterStream("resume");
				char buffer[] = new char[1024];
				int len =0;
				FileWriter out = new FileWriter("D:\\date.txt");
				while((len=reader.read(buffer))>0){
					contentStr += new String(buffer);
					out.write(buffer,0,len);
				}
				out.close();
				reader.close();
			}
			System.out.println(content);
			System.out.println(contentStr);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectUtils.release(conn, st, rs);
		}
	}
	*/
	@Test
	public void addP() throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn=ConnectUtils.getConnection();
			String sql="insert into testclob(image) values(?)";
			st = (PreparedStatement) conn.prepareStatement(sql);
			//准备image 字节流对象
			String path = LargeNumber.class.getClassLoader().getResource("download/2.jpg").getPath();
			path = path.replaceAll("%20","");
			File file= new File(path);
			FileInputStream fis=new FileInputStream(file);
			st.setBinaryStream(1,fis, (int)file.length());
			int num = st.executeUpdate();
			if(num>0){
				System.out.println("插入成功");
			}
			fis.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			ConnectUtils.release(conn, st, rs);
		}
	}
	@Test
	public void readP() throws SQLException{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn = ConnectUtils.getConnection();
			String sql= "select image from testclob where id=?";
			st=(PreparedStatement) conn.prepareStatement(sql);
			st.setInt(1, 12);
			rs=st.executeQuery();
			if(rs.next()){
				InputStream in= rs.getBinaryStream("image");
				int len =0;
				byte buffer[] = new byte[1024];
				FileOutputStream out = new FileOutputStream("D://1.jpg");
				while((len = in.read(buffer))>0){
					out.write(buffer,0,len);
				}
				in.close();
				out.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectUtils.release(conn, st, rs);
		}
		
	}
}
