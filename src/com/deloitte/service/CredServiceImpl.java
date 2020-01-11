package com.deloitte.service;

import java.sql.SQLException;

import com.deloitte.model.User;
import com.deloitte.repo.CredRepo;
import com.deloitte.repo.CredRepoImpl;
import com.deloitte.util.InvalidIDException;
import com.deloitte.util.InvalidNameException;
import com.deloitte.util.InvalidPasswordException;
import com.deloitte.util.UserAlreadyExistsException;
import com.deloitte.util.UserDoesNotExistException;

public class CredServiceImpl implements CredService {
	CredRepo cr = new CredRepoImpl();

	@Override
	public boolean addUser(User user) throws InvalidIDException, InvalidNameException, InvalidPasswordException, UserAlreadyExistsException {
		if (getUserById(user.getId()) == null) {
			if(user.getId()>9999 && user.getId()<100000) {
				int passlength = user.getPass().length();
				if(passlength>=8) {
					int namelength = user.getName().length();
					if(namelength>2) {
						try {
							cr.addUser(user);
							return true;
						} catch (SQLException e) {
							return false;
						}
					} else {
						throw new InvalidNameException();
					}
				} else {
					throw new InvalidPasswordException();
				}
			} else {
				throw new InvalidIDException();
			}
		} else {
			throw new UserAlreadyExistsException();
		}
	}

	@Override
	public User getUserById(Long uid) {
		try {
			User user = cr.getUserById(uid);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateUser(User user) throws UserDoesNotExistException, InvalidNameException, InvalidPasswordException {
		if (getUserById(user.getId()) != null) {
			int passlength = user.getPass().length();
			if(passlength>=8) {
				int namelength = user.getName().length();
				if(namelength>2) {
					try {
						cr.updateUser(user);
						return true;
					} catch (SQLException e) {
						return false;
					}
				} else {
					throw new InvalidNameException();
				}
			} else {
				throw new InvalidPasswordException();
			}
		} else {
			throw new UserDoesNotExistException();
		}
	}
}
