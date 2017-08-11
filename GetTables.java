package database_console.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTables {
	
	public dealTable[] getDeal(int chunkNumber) throws SQLException{
		
		int chunkSize = 50;
		
		int size = 0;
		int count = 0;
		PreparedStatement st;
		ResultSet r1 = null;
		
		try {
			st = ((Connection) DBconnect.con).prepareStatement("select * from deal limit ?, ?");
			st.setInt(1, (chunkNumber * chunkSize));
			st.setInt(2, ((chunkNumber + 1) * chunkSize));
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
		 dealTable[] tab=new dealTable[size];
		 while (r1.next()) {


	          tab[count].deal_id=  r1.getInt("deal_id");
	          tab[count].deal_time=  r1.getString("deal_time");
	          tab[count].deal_counterparty_id=  r1.getInt("deal_counterparty_id");
	          tab[count].deal_instrument_id=  r1.getInt("deal_instrument_id");
	          tab[count].deal_type=  r1.getString("deal_type");
	          tab[count].deal_amount=  r1.getDouble("deal_amount");
	          tab[count].deal_quantity=  r1.getInt("deal_quantity");
	          count++;
	      }
		
		return tab ;
		
	}
	
	
public instrumentTable[] getInstrument(int chunkNumber) throws SQLException{
		
		int chunkSize = 50;
		
		int size = 0;
		int count = 0;
		PreparedStatement st;
		ResultSet r1 = null;
		
		try {
			st = ((Connection) DBconnect.con).prepareStatement("select * from instrument limit ?, ?");
			st.setInt(1, (chunkNumber * chunkSize));
			st.setInt(2, ((chunkNumber + 1) * chunkSize));
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
		 instrumentTable[] tab=new instrumentTable[size];
		 while (r1.next()) {


	          tab[count].instrument_id=  r1.getInt("instrument_id");
	          tab[count].instrument_name=  r1.getString("instrument_name");
	          count++;
	      }
		
		return tab ;
		
	}


public userTable[] getUser(int chunkNumber) throws SQLException{
	
	int chunkSize = 50;
	
	int size = 0;
	int count = 0;
	PreparedStatement st;
	ResultSet r1 = null;
	
	try {
		st = ((Connection) DBconnect.con).prepareStatement("select * from users limit ?, ?");
		st.setInt(1, (chunkNumber * chunkSize));
		st.setInt(2, ((chunkNumber + 1) * chunkSize));
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
	 userTable[] tab=new userTable[size];
	 while (r1.next()) {


          tab[count].user_id=  r1.getInt("user_id");
          tab[count].user_pwd=  r1.getString("user_name");
          count++;
      }
	
	return tab ;
	
}

}
