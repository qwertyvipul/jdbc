package jdbc_getting_started;

import java.io.*;
import java.sql.*;

public class JDBClob {

	public static void main(String[] args) {
		try{

			JDBConnect jdb = new JDBConnect();
			String query = "update employee set large_text = ? where name = ?";
			PreparedStatement stmt = jdb.conn.prepareStatement(query);
			
			//Writing BLOB
			File sample = new File("sample.txt");
			System.out.println("Reading the file: " + sample.getAbsolutePath());
			
			FileReader input = new FileReader(sample);
			stmt.setCharacterStream(1, input);
			stmt.setString(2, "Vipul");
			
			stmt.executeUpdate();
			
			//Reading BLOB
			Statement readstmt = jdb.conn.createStatement();
			query = "select large_text from employee where name = 'Vipul'";
			ResultSet result = readstmt.executeQuery(query);
			
			File newFile = new File("db_sample.txt");
			FileWriter output = new FileWriter(newFile);
			
			if(result.next()){
				Reader fileData = result.getCharacterStream("large_text");
				
				int inputChar;
				while((inputChar = fileData.read())>0){
					output.write(inputChar);
				}
			}
			
			System.out.println("Successfull!");
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
