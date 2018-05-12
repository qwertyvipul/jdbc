package jdbc_getting_started;

import java.sql.*;

public class JDBResultSetMetaData {
	public static void main(String args[]){
		try{
			JDBConnect jdb = new JDBConnect();
			String query = "select * from employee";
			ResultSet result = jdb.stmt.executeQuery(query);
			ResultSetMetaData rsmd = result.getMetaData();
			
			System.out.println("*** Result Set Meta Data ***");
			
			int columnCount = rsmd.getColumnCount();
			System.out.println("Column count: " + columnCount);
			
			for(int column=1; column<=columnCount; column++){
				System.out.println("----------------------------------------");
				System.out.println("Column name: " + rsmd.getColumnName(column));
				System.out.println("Column type name: " + rsmd.getColumnTypeName(column));
				System.out.println("Is Nullable: " + rsmd.isNullable(column));
				System.out.println("Is Auto Increment: " + rsmd.isAutoIncrement(column));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
