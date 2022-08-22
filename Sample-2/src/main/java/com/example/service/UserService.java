package com.example.service;

import java.util.List;

import com.example.model.Role;
import com.example.model.User;

public interface UserService {

	public List<User> listUsers();

	public List<User> listUsersWithPagination(int pageNo, int usersCount);

	public User getUserById(int id);

	public User addUser(User userDto);

	public String deleteUser(int id);

	public User updateById(User userDto);

	public List<User> getUsersByRoleId(int roleId);

	public List<Role> getRolesByUserId(int id);
}
