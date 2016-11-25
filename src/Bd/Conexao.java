package Bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
	private Conexao() {;}
	
	private static Connection conn ;
	static{ 
		try{
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			//Class.forName(driverName, true, DriverManager.class.getClassLoader());
			
			String serverName = "localhost";
			String mydatabase = "grotox";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);
			
			if( conn != null){
				System.out.println("FOI!...");
			}
			else
				System.out.println("Deu merda!...");
		}catch(SQLException e){
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getThis(){
		return conn;
	}
	
	
}
