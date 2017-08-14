package database_console.connect;

import java.sql.Connection;
import java.sql.DriverManager;
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
			//st = ((Connection) DBconnect.con).prepareStatement("show tables ");
			
			Class.forName("com.mysql.jdbc.Driver");
			String host = "jdbc:mysql://192.168.99.100:3306/db_grad_cs_1917";
			String username = "root";
			String password = "ppp";
			Connection con = DriverManager.getConnection(host,username,password);
			st = con.prepareStatement("show tables ");
		    //st2= con.prepareStatement("")
			r1=st.executeQuery();
			
		} 
	    catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ResultSet r1 = null;
		try {
			while (r1.next()) {
				System.out.println(r1.getString("Tables_in_db_grad_cs_1917"));

			      size++;
			     
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String[] str=new String[size];
		 r1.beforeFirst();
		 while (r1.next()){
			 
	          str[count]=  r1.getString("Tables_in_db_grad_cs_1917");
	          System.out.println(str[count]);
	          count++;
	      }
		 
		return str ;
	}

}
