package com.example.service;

import java.util.List;

import com.example.model.User;
import com.example.model.UserDto;

public interface UserService {

	public List<UserDto> listUsers();

	public List<UserDto> listUsersWithPagination(int pageNo, int usersCount);

	public UserDto getUserById(int id);

	public UserDto addUser(User user);

	public String deleteUser(int id);

	public UserDto updateById(User user);

	public List<UserDto> getUsersByRoleId(int roleId);

//	public RoleDto getRoleByUserId(int id);

}
