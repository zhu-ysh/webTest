package com.bookmanager.tool;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Context sourceCtx = new InitialContext();
			DataSource ds = (DataSource)sourceCtx.lookup("java:comp/env/jdbc/oracle");
			Connection conn = ds.getConnection();
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
