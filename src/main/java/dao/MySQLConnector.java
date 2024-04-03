package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {

	// 사용할 객체 초기화
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 데이터베이스 접속 설정 정보
	/** JDBC DRIVER 패키지 정보 */
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	/** 데이터베이스 URL */
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/simple_shop";

	/** 데이터베이스 아이디 */
	private final String DB_ID = "root";

	/** 데이터베이스 암호 */
	private final String DB_PWD = "1234";

	public MySQLConnector() {
		// TODO Auto-generated constructor stub
	}

	public Connection connection() {
		if (conn != null) {
			try {

				// 데이터베이스 객체 생성
				Class.forName(this.JDBC_DRIVER);
				this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);

				return conn;

			} catch (Exception e) {
				System.err.println("CONNECTION ERR : " + e.getMessage());
			}
		}
		return null;
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
			if (connector != null) {
				rs.close();
			}
			if (connector != null) {
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
			if (connector != null) {
				rs.close();
			}
			if (connector != null) {
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
			if (connector != null) {
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
