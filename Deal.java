package database_console.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deal {
	
	public void displayDeal() { 
		int size = 0;
		int count = 0;
		PreparedStatement st;
		ResultSet r1;
		try {
			st = ((Connection) DBconnect.con).prepareStatement("select * from deal ");
		
			r1=st.executeQuery();
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
