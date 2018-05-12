package jdbc_getting_started;

import java.io.*;
import java.sql.*;

public class JDBCBlob {
	public static void main(String args[]){
		
		try{

			JDBConnect jdb = new JDBConnect();
			String query = "update employee set large_file = ? where name = ?";
			PreparedStatement stmt = jdb.conn.prepareStatement(query);
			
			//Writing BLOB
			File sample = new File("sample.pdf");
			System.out.println("Reading the file: " + sample.getAbsolutePath());
			
			FileInputStream input = new FileInputStream(sample);
			stmt.setBinaryStream(1, input);
			stmt.setString(2, "Vipul");
			
			stmt.executeUpdate();
			
			//Reading BLOB
			Statement readstmt = jdb.conn.createStatement();
			query = "select large_file from employee where name = 'Vipul'";
			ResultSet result = readstmt.executeQuery(query);
			
			File newFile = new File("db_sample.pdf");
			FileOutputStream output = new FileOutputStream(newFile);
			
			if(result.next()){
				InputStream fileData = result.getBinaryStream("large_file");
				
				byte buffer[] = new byte[1024];
				while(fileData.read(buffer)>0){
					output.write(buffer);
				}
			}
			
			System.out.println("Successfull!");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
