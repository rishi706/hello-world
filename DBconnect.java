package database_console.connect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnect {
	
	
	public static Object con;

	public static void main(String[] args){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";
			String username = "root";
			String password = "ppp";
			Connection con = DriverManager.getConnection(host,username,password);
			//System.out.println( con.getCatalog() );
			
		}
		catch(SQLException err){
			err.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
