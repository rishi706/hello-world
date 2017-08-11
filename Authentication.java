package database_console.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {
	
	@SuppressWarnings("null")
	public int getUserByAuthToken(String token){
		PreparedStatement st;
		ResultSet r1 = null;
		int userid = 0;
		
		try {
			st = ((Connection) DBconnect.con).prepareStatement("select * from Authentication where token = ? ");
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
			return (Integer) null; 
		}
		
		return userid;
		
	}
	
	
	public void putAuthInfo(int id, String token){
		PreparedStatement st;
		//ResultSet r1 = null;
		
		try {
			st = ((Connection) DBconnect.con).prepareStatement("insert into authentication values (?, ?)");
			st.setInt(1, id);
			st.setString(1, token);
		
			st.executeUpdate();
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteAuthInfo(String token){
		PreparedStatement st;
		//ResultSet r1 = null;
		
		try {
			st = ((Connection) DBconnect.con).prepareStatement("delete from authentication where token = ?");
			st.setString(1, token);
		
			st.executeUpdate();
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
