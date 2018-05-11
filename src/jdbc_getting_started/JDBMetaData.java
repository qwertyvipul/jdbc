package jdbc_getting_started;

import java.sql.*;

public class JDBMetaData {
	public static void main(String args[]){
		try{
			JDBConnect jdb = new JDBConnect();
			DatabaseMetaData dmd = jdb.conn.getMetaData();
			
			System.out.println("*** Basic Info ***");
			System.out.println("Product Name: " + dmd.getDatabaseProductName());
			System.out.println("Product Version: " + dmd.getDatabaseProductVersion());
			System.out.println("JDBC Driver Name: " + dmd.getDriverName());
			System.out.println("JDBC Driver Version: " + dmd.getDriverVersion());
			System.out.println();
			
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = "%";
			String columnNamePattern = null;
			String[] types = null;
			
			ResultSet result = dmd.getTables(catalog, schemaPattern, tableNamePattern, types);
			
			System.out.println("*** Schema Info ***");
			System.out.println("--- All Table Names ---");
			while(result.next()){
				System.out.println(result.getString("TABLE_NAME"));
			}
			
			//All table names starting with e
			tableNamePattern = "e%";
			result = dmd.getTables(catalog, schemaPattern, tableNamePattern, types);
			
			System.out.println("*** Schema Info ***");
			System.out.println("--- My Table Names ---");
			while(result.next()){
				System.out.println(result.getString("TABLE_NAME"));
			}
			
			result = dmd.getColumns(catalog, schemaPattern, "employee", columnNamePattern);
			System.out.println("--- Employee Column Names ---");
			while(result.next()){
				System.out.println(result.getString("COLUMN_NAME"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
