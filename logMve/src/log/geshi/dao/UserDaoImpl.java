package log.geshi.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import log.geshi.connection.JDBCutils;
import log.geshi.domain.Users;

public class UserDaoImpl implements UserDaoIF {

	public   boolean find(String name, String password) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		 
		try{
			conn = JDBCutils.getConnection();
			String sql = "select * from users where name=? and password=?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, password);
			  rs =  (ResultSet) st.executeQuery();
			   
			while(rs.next()){
				
			 
				return true ;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			JDBCutils.release(conn, st, rs);
		}
		return false;
	}

	public void add(Users user) {
		 Connection conn = null;
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 try{
			 conn = JDBCutils.getConnection();
			 String sql = "insert into users values(?,?,?)";
			 st = (PreparedStatement) conn.prepareStatement(sql);
			 st.setString(1, user.getName());
			 st.setString(2, user.getPassword());
			 st.setString(3, user.getEmail());
			 st.executeQuery();
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }

	}

	public boolean find(String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JDBCutils.getConnection();
			String sql = "select * from users where name=?";
			st = (PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, name);
			rs=(ResultSet) st.executeQuery();
			while(rs.next()){
				return true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

}
