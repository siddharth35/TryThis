package com.deloitte.repo;

import java.sql.SQLException;

import com.deloitte.model.User;

public interface CredRepo {
	void addUser(User user) throws SQLException;
	User getUserById(Long uid) throws SQLException;
	void updateUser(User user) throws SQLException;
}
