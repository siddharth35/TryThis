package com.deloitte.service;


import com.deloitte.model.User;
import com.deloitte.util.InvalidIDException;
import com.deloitte.util.InvalidNameException;
import com.deloitte.util.InvalidPasswordException;
import com.deloitte.util.UserAlreadyExistsException;
import com.deloitte.util.UserDoesNotExistException;

public interface CredService {
	boolean addUser(User user) throws InvalidIDException, InvalidNameException, InvalidPasswordException, UserAlreadyExistsException;
	User getUserById(Long uid);
	boolean updateUser(User user) throws UserDoesNotExistException, InvalidNameException, InvalidPasswordException;
}
