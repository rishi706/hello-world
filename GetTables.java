package database_console.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTables {
	
	public dealTable[] getDeal(int chunkNumber) throws SQLException, ClassNotFoundException{
		
		int chunkSize = 50;
		
		int size = 0;
		int count = 0;
		PreparedStatement st;
		ResultSet r1 = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";
			String username = "root";
			String password = "ppp";
			Connection con = DriverManager.getConnection(host,username,password);
			st = con.prepareStatement("select * from deal limit ?, ?");
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
		 r1.beforeFirst();
		 while (r1.next()) {
			 
			 dealTable r =new dealTable();

	          r.deal_id=  r1.getInt("deal_id");
	          r.deal_time=  r1.getString("deal_time");
	          r.deal_counterparty_id=  r1.getInt("deal_counterparty_id");
	          r.deal_instrument_id=  r1.getInt("deal_instrument_id");
	          r.deal_type=  r1.getString("deal_type");
	          r.deal_amount=  r1.getDouble("deal_amount");
	          r.deal_quantity=  r1.getInt("deal_quantity");
	          tab[count]= r;
	          count++;
	      }
		
		return tab ;
		
	}
	
	
public instrumentTable[] getInstrument(int chunkNumber) throws SQLException, ClassNotFoundException, NullPointerException{
		
		int chunkSize = 50;
		
		int size = 0;
		int count = 0;
		PreparedStatement st;
		ResultSet r1 = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";
			String username = "root";
			String password = "ppp";
			Connection con = DriverManager.getConnection(host,username,password);
			st = con.prepareStatement("select * from instrument limit ?, ?");
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
				//System.out.println(r1.getInt("instrument_id"));

			      size++;
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(size);
		 instrumentTable[] tab = new instrumentTable[size];
		 //instrumentTable r = new instrumentTable();
		 r1.beforeFirst();
		 while (r1.next()) {
			 //System.out.println(r1.getInt("instrument_id"));
			 //System.out.println(r1.getString("instrument_name"));
			 instrumentTable r = new instrumentTable();
			 r.setInstrument_id(r1.getInt("instrument_id"));
			 r.setInstrument_name(r1.getString("instrument_name"));
			 //tab[count].copy(r);
			 tab[count]=r;


	          //tab[count].instrument_id=  r1.getInt("instrument_id");
	          //tab[count].instrument_name=  r1.getString("instrument_name");
	          count++;
	      }
		
		return tab ;
		
	}


public userTable[] getUser(int chunkNumber) throws SQLException, ClassNotFoundException{
	
	int chunkSize = 50;
	
	int size = 0;
	int count = 0;
	PreparedStatement st;
	ResultSet r1 = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String host = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";
		String username = "root";
		String password = "ppp";
		Connection con = DriverManager.getConnection(host,username,password);
		st = con.prepareStatement("select * from users limit ?, ?");
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
	 //userTable r = new userTable();
	 r1.beforeFirst();
	 while (r1.next()) {
		 
		 userTable r = new userTable();


          r.user_id=  r1.getString("user_id");
          r.user_pwd=  r1.getString("user_pwd");
          //tab[count].copy(r);
          tab[count]= r;
          count++;
      }
	
	return tab ;
	
}

}
