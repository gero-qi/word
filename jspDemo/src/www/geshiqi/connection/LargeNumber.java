package www.geshiqi.connection;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

public class LargeNumber {

	@Test
	public void add(){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Reader reader = null;
	try{
		conn = ConnectUtils.getConnection();
		String sql = "insert into testclob(resume) values(?)";
		st = (PreparedStatement) conn.prepareStatement(sql);
		String path = LargeNumber.class.getClassLoader().getResource("data.text").getPath();
		path = path.replaceAll("%20", "");
		File file  = new File(path);
		reader = new FileReader(file);
	
	}
	}

}
