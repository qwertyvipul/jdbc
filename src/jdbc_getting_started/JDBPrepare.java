package jdbc_getting_started;

import java.sql.*;
import jdbc_getting_started.JDBConnect;

public class JDBPrepare {
	public static void main(String args[]){
		
		try{
			
			JDBConnect jdb = new JDBConnect();
			
			String query = "select * from employee where age = ? and name = ?";
			PreparedStatement stmt = jdb.conn.prepareStatement(query);
			stmt.setInt(1, 20);
			stmt.setString(2, "Vipul");
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next()){
				System.out.println(result.getString("id") + ", " + result.getString("name") + ", " + result.getString("age"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
