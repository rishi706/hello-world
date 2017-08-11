package database_console.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deal {
	
	public String[] displayDeal() throws SQLException { 
		int size = 0;
		int count = 0;
		PreparedStatement st;
		ResultSet r1 = null;
		
		try {
			st = ((Connection) DBconnect.con).prepareStatement("show tables ");
		
			r1=st.executeQuery();
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (r1.next()) {

			      size++;
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String[] str=new String[size];
		 while (r1.next()) {


	          str[count]=  r1.getString("Tables_in_db_grad_cs_1917");
	          count++;
	      }
		 
		return str ;
	}

}
