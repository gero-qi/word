package Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class PersonDB {
	public Boolean showResult(int i){
		if(i>0){
			return true;
			
		}else{
			return false;
		}
	}
	public boolean inset(PerSonSchema tpersonSchema){
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		int count=0;
		try {
			con= DBUtils.getConnection();
			String sql = "insert into person values (?,?)";
			stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, tpersonSchema.getId());
			stmt.setString(2, tpersonSchema.getName());
			count = stmt.executeUpdate();
			DBUtils.closeAll(rs, stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count>0){
			return true;
			
		}else{
			return false;
		}
	}
	
	public boolean update(PerSonSchema  tpersonSchema){//修改
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=DBUtils.getConnection();
			String sql = "update person set name=? where id=?";
			stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, tpersonSchema.getName());
			stmt.setString(2, tpersonSchema.getId());
			count=stmt.executeUpdate();
			DBUtils.closeAll(rs, stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if(count>0){
			return true;
			
		}else{
			return false;
		}
	}
	public Boolean  delete(PerSonSchema  tpersonSchema){//删除
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		int count=0;
		
		try {
			con=DBUtils.getConnection();
			String sql = "delete from  person  where id=?";
			stmt = (PreparedStatement) con.prepareStatement(sql);
			 
			stmt.setString(1, tpersonSchema.getId());
			count=stmt.executeUpdate();
			DBUtils.closeAll(rs, stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if(count>0){
			return true;
			
		}else{
			return false;
		}
		
		
	}
	public PerSonSchema  getById(String id){
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		PerSonSchema per =  new PerSonSchema();
		
		try {
			con=DBUtils.getConnection();
			String sql = "select *  from  person  where id=?";
			stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			while(rs.next()){
			 
				per.setId(rs.getString(1));
				per.setName(rs.getString(2));
				return  per;
			}
			DBUtils.closeAll(rs, stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return per;	
	}
	
	
}
