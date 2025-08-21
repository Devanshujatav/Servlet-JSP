package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//
public class LoginDAO {
	String url = "jdbc:mysql://localhost:3306/mydatabase";
	String username = "root";
	String password = "djSql@10";
	String sql = "SELECT * FROM login WHERE uname=? AND pass=?";
	
	public boolean check(String uname , String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url , username , password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1 , uname);
			st.setString(2 , pass);
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				System.out.println("user:- " +rs.getString(1));
				System.out.println("password:- " +rs.getString(2));
				return true;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return false;
	}
}

//
//public class LoginDAO {
//    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "djSql@10";
//    private static final String SQL = "SELECT * FROM login WHERE uname=? AND pass=?";
//    
//    public boolean check(String uname, String pass) {
//        if (uname == null || pass == null) {
//            return false;
//        }
//        
//        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//             PreparedStatement st = con.prepareStatement(SQL)) {
//            
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            st.setString(1, uname);
//            st.setString(2, pass);
//            
//            try (ResultSet rs = st.executeQuery()) {
//                return rs.next();
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace(); // Fixed: actually prints the error
//        }
//        
//        return false;
//    }
//}
