package DB;

import java.sql.*;

public class dbconnection {
	private String dbName = "root";
	private String dbUrl = "jdbc:mysql://localhost:3306/user";
	private String dbpassword = "199614";
	private String jdbcName = "com.mysql.jdbc.Driver";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public dbconnection(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		this.conn = conn;
		this.pstmt = pstmt;
		this.rs = rs;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(jdbcName);
			conn = DriverManager.getConnection(dbUrl, dbName, dbpassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * @description 关闭数据库相关资源
	 */
	public void closeJDBC() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
