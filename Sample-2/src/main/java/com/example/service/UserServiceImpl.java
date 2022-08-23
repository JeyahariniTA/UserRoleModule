package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.model.UserDto;
import com.example.repository.UserJPARepository;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserJPARepository jpaRepository;

	@Autowired
	UserMapper userMapper;

	@Autowired
	RoleMapper roleMapper;

	@Override
	public List<UserDto> listUsers() {
		// Sort sortOrder = Sort.by("id").descending();
		// PageRequest pageReq = PageRequest.of(1, 2);
//		jpaRepository.findAll(pageReq).forEach(users -> list.add(users));
		return userMapper.convertUserToDto(jpaRepository.findAll());
	}

	@Override
	public UserDto getUserById(int id) {
		try {
			if (userRepository.existsById(id)) {
				return userMapper.convertUserToDto(userRepository.findById(id).get());
			} else {
				return new UserDto();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public UserDto addUser(User user) {
		return userMapper.convertUserToDto(userRepository.save(user));
	}

	@Override
	public String deleteUser(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return "Deleted Successfully!";
		} else {
			return "Please provide valid user id to delete.";
		}
	}

	@Override
	public UserDto updateById(User user) {
		if (jpaRepository.existsById(user.getId())) {
//			System.out.println("user: " + user.toString());
			return userMapper.convertUserToDto(jpaRepository.save(user));
		} else {
			return new UserDto();
		}
	}

	public List<UserDto> getUsersByRoleId(int roleId) {
		return userMapper.convertUserToDto(jpaRepository.findByRoleId(roleId));

	}

	/*
	 * @Override public RoleDto getRoleByUserId(int id) {
	 * System.out.println("findrolebyid" + jpaRepository.findRoleById(id)); return
	 * roleMapper.convertRoleToDto(jpaRepository.findRoleById(id)); }
	 */

	@Override
	public List<UserDto> listUsersWithPagination(int pageNo, int usersCount) {
//		Sort sortOrder = Sort.by("id").descending();
		List<UserDto> list = new ArrayList<>();
		PageRequest pageReq = PageRequest.of(pageNo, usersCount);
		jpaRepository.findAll(pageReq).forEach(users -> list.add(userMapper.convertUserToDto(users)));
		return list;
	}

}
