package jdbc_getting_started;

import java.sql.*;

public class JDBConnect {
	Connection conn;
	Statement stmt, pstmt;
	
	public JDBConnect(){
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?autoReconnect=true&useSSL=false", "root", "password");
			stmt = conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
