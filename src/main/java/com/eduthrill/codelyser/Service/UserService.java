package com.eduthrill.codelyser.Service;

import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Entity.User;

import com.eduthrill.codelyser.Entity.UserRole;
import com.eduthrill.codelyser.Model.CategoryModel;

import java.util.Set;



public interface UserService {



	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	public User findUser(String username);

	public void deleteUser(Long id);

	User updateUser(User user);
//	List<User> getUsers();
}
