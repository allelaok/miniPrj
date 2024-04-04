package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {

	// �궗�슜�븷 媛앹껜 珥덇린�솕
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// �뜲�씠�꽣踰좎씠�뒪 �젒�냽 �꽕�젙 �젙蹂�
	/** JDBC DRIVER �뙣�궎吏� �젙蹂� */
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	/** �뜲�씠�꽣踰좎씠�뒪 URL */
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/simple_shop";

	/** �뜲�씠�꽣踰좎씠�뒪 �븘�씠�뵒 */
	private final String DB_ID = "root";

	/** �뜲�씠�꽣踰좎씠�뒪 �븫�샇 */
	private final String DB_PWD = "1234";

	public MySQLConnector() {
		// TODO Auto-generated constructor stub
	}

	public Connection connection() {
		
			try {

				// �뜲�씠�꽣踰좎씠�뒪 媛앹껜 �깮�꽦
				Class.forName(this.JDBC_DRIVER);
				this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);

				return conn;

			} catch (Exception e) {
				System.err.println("CONNECTION ERR : " + e.getMessage());
			}
		
		return conn;
	}

	public void close(Connection connector) {
		if (connector != null) {
			try {
				connector.close();
			} catch (SQLException e) {
				System.err.println("Connection CLOSE ERR : " + e.getMessage());
			}
		}
	}

	public void close(Connection connector, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (connector != null) {
				connector.close();
			}
		} catch (SQLException e) {
			System.err.println("Connection, Statement, ResultSet CLOSE ERR : " + e.getMessage());
		}
	}

	public void close(Connection connector, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (connector != null) {
				connector.close();
			}
		} catch (SQLException e) {
			System.err.println("Connection, PreparedStatement, ResultSet CLOSE ERR : " + e.getMessage());
		}
	}

	public void close(Connection connector, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (connector != null) {
				connector.close();
			}
		} catch (SQLException e) {
			System.err.println("Connection, PreparedStatement CLOSE ERR : " + e.getMessage());
		}
	}

	public void close(Connection connector, Statement stmt) {
		try {
			if (connector != null) {
				stmt.close();
			}
			if (connector != null) {
				connector.close();
			}
		} catch (SQLException e) {
			System.err.println("Connection, Statement CLOSE ERR : " + e.getMessage());
		}
	}

}
