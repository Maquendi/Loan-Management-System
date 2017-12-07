package com.sistemaprestamo.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.*;

public class Conexion {

	private static Connection conn = null;
	
	
	private Conexion() {}
	
	
	public static Connection getConexion() {
		
		
		
		
		//InputStream in = getClass().getResourceAsStream("config.properties");
		
		
		if(conn == null) {
		
		 Properties prop = new Properties();
		
		
		 
		try {
			
			InputStream in = new FileInputStream("config.properties");
			prop.load(in);
			in.close();
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		String driver = prop.getProperty("driver.name");
		String server_url = prop.getProperty("server.name");
		String user = prop.getProperty("user.name");
		String password = prop.getProperty("user.password");
		
		
	 try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(server_url, user, password);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Could not load Driver");
		}
		
	  }
		
	  return conn;
		
	}
	

}
