package database_console.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {
	
	//@SuppressWarnings("null")
	public int getUserByAuthToken(String token) throws ClassNotFoundException{
		
		PreparedStatement st;
		ResultSet r1 = null;
		int userid = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";
			String username = "root";
			String password = "ppp";
			Connection con = DriverManager.getConnection(host,username,password);
			st = con.prepareStatement("select * from Authentication where token = ? ");
			st.setString(1, token);
		
			r1=st.executeQuery();
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			userid = r1.getInt("user_id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return (Integer) null; 
		}
		
		return userid;
		
	}
	
	
	public void putAuthInfo(int id, String token) throws ClassNotFoundException{
		PreparedStatement st;
		//ResultSet r1 = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";
			String username = "root";
			String password = "ppp";
			Connection con = DriverManager.getConnection(host,username,password);
			st = con.prepareStatement("insert into authentication values (?, ?)");
			st.setInt(1, id);
			st.setString(1, token);
		
			st.executeUpdate();
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteAuthInfo(String token) throws ClassNotFoundException{
		PreparedStatement st;
		//ResultSet r1 = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";
			String username = "root";
			String password = "ppp";
			Connection con = DriverManager.getConnection(host,username,password);
			st = con.prepareStatement("delete from authentication where token = ?");
			st.setString(1, token);
		
			st.executeUpdate();
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
