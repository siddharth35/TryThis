package com.deloitte.repo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.deloitte.model.User;

public class CredRepoImpl implements CredRepo {
	
	@Override
	public void addUser(User user) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "admin");
		PreparedStatement ps = conn.prepareStatement("INSERT INTO USER_DETAILS VALUES(?,?,?,?,?)");
		ps.setLong(1, user.getId());
		ps.setString(2, user.getPass());
		ps.setString(3, user.getName());
		ps.setString(4, user.getGender());
		ps.setString(5, user.getCountry());
		ps.executeUpdate();
	}

	@Override
	public User getUserById(Long uid) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "admin");
		System.out.println(conn);
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER_DETAILS WHERE ID=?");
		ps.setLong(1, uid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setId(rs.getLong(rs.findColumn("ID")));
			user.setPass(rs.getString(rs.findColumn("PASSWORD")));
			user.setName(rs.getString(rs.findColumn("NAME")));
			user.setGender(rs.getString(rs.findColumn("GENDER")));
			user.setCountry(rs.getString(rs.findColumn("COUNTRY")));
			return user;
		} else {
			return null;
		}
	}

	@Override
	public void updateUser(User user) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "admin");
		PreparedStatement ps = conn.prepareStatement("UPDATE USER_DETAILS SET PASSWORD=?, NAME=?, GENDER=?, COUNTRY=? WHERE ID=?");
		ps.setString(1, user.getPass());
		ps.setString(2, user.getName());
		ps.setString(3, user.getGender());
		ps.setString(4, user.getCountry());
		ps.setLong(5, user.getId());
		ps.executeUpdate();
	}

}
