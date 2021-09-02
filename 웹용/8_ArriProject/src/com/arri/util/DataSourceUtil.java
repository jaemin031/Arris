package com.arri.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceUtil {
	static DataSource ds;
	
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/arri");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void close(ResultSet rs, Statement st,Connection con){
		try {
			if (rs != null)	rs.close();
			if (st != null)	st.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}


