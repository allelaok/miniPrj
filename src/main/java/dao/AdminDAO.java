package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 관리자 관련 DAO
 * @author 임주연
 * **/
public class AdminDAO {
	private Connection connector = null;
	private MySQLConnector datasource = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AdminDAO() {
		datasource = new MySQLConnector();
	}
	
	public boolean adminLogin(String id, String pwd) {
		boolean state = false;
		try {
			connector = datasource.connection();
			String query = "select count(*) from tblAdmin where admin_id = ? and admin_pwd = ?";
			
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			int count = 0;
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
			
			if (count == 1) {
				state = true;
			}
		} catch (SQLException e) {
			System.err.println("adminLogin(): " + e.getMessage());
		} finally {
			datasource.close(connector, pstmt, rs);
		}
		
		return state;
	}
	
}
