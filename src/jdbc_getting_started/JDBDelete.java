package jdbc_getting_started;

import java.sql.*;
import jdbc_getting_started.JDBConnect;

public class JDBDelete {
	public static void main(String args[]){
		
		try{
			
			JDBConnect jdb = new JDBConnect();
			String query = "delete from employee where age = 45";
			int rowsAffected = jdb.stmt.executeUpdate(query);
			
			System.out.println(rowsAffected + " row(s) deleted");
			
			query = "select * from employee";
			ResultSet result = jdb.stmt.executeQuery(query);
			
			while(result.next()){
				System.out.println(result.getString("id") + ", " + result.getString("name") + ", " + result.getString("age"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
