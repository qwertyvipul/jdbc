package jdbc_getting_started;

import java.sql.*;
import jdbc_getting_started.JDBConnect;

public class JDBTransactions {
	public static void main(String args[]){
		
		try{
			JDBConnect jdb = new JDBConnect();
			jdb.conn.setAutoCommit(false);
			
			String query = "delete from employee where name = 'Vipul'";
			jdb.stmt.executeUpdate(query);
			
			query = "select * from employee";
			ResultSet result = jdb.stmt.executeQuery(query);
			
			while(result.next()){
				System.out.println(result.getString("id") + ", " + result.getString("name") + ", " + result.getString("age"));
			}
			
			jdb.conn.rollback();
			
			result = jdb.stmt.executeQuery(query);
			
			while(result.next()){
				System.out.println(result.getString("id") + ", " + result.getString("name") + ", " + result.getString("age"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
