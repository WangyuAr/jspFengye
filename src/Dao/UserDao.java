package Dao;

import DB.dbconnection;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import Bean.User;

public class UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List <String>Userlist;
	dbconnection db = new dbconnection(conn, pstmt, rs);

	public List getalluser(String username) {
		User user = null;
		conn = db.getConnection();
		Userlist=new ArrayList<String>();
		String sql = "select * from user where username like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+username+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Userlist.add(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Userlist;
	}

}
