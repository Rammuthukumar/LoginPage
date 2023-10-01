package com.rammk.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	String url="jdbc:mysql://localhost:3306/jsp";
	String user="root";
	String pass="ramsnth@18";
	String query="select * from login where unmae=? and pass=?";

	public boolean check(String usname,String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, usname);
			st.setString(2,password);
			
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
