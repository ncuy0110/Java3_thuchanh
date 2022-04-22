package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static String DB_HOST = "localhost";
	private static int DB_PORT = 3306;
	private static String DB_NAME = "demo";
	private static String DB_USERNAME = "root";
	private static String DB_PASSWORD = "uy050770";
	
	public static Connection getConnection() throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");  
		String uri = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
		Connection conn = null;
		try {
			System.out.println(uri);
			conn = DriverManager.getConnection(uri, DB_USERNAME, DB_PASSWORD);
			System.out.println("Connect success!");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connect failed!");
		}
		
		return conn;
	}
//	public static void main(String[] args) throws ClassNotFoundException {
//		DatabaseConnector.getConnection();
//	}
}
