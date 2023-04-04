package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PostDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private DataSource dataSource;
	
	private static PostDAO dao = new PostDAO();
	private PostDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static PostDAO getInstance() {
		return dao;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
