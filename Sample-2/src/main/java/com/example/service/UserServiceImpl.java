package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.AddressRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserJPARepository;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserJPARepository jpaRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<User> listUsers() {
		// Sort sortOrder = Sort.by("id").descending();
		// PageRequest pageReq = PageRequest.of(1, 2);
//		jpaRepository.findAll(pageReq).forEach(users -> list.add(users));
		return jpaRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		try {
			if (userRepository.existsById(id)) {
				return userRepository.findById(id).get();
			} else {
				return new User();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public User addUser(User userDto) {
		return userRepository.save(userDto);
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
	public User updateById(User userDto) {
		if (userRepository.existsById(userDto.getId())) {
			return userRepository.save(userDto);
		} else {
			return new User();
		}
	}

	public List<User> getUsersByRoleId(int roleId) {

//		jpaRepository.findB
//		roleRepository.findUsersByRole(roleName);
		return jpaRepository.findByRoleId(roleId);

	}

	@Override
	public List<Role> getRolesByUserId(int id) {
		return jpaRepository.findRoleById(id);
	}

	@Override
	public List<User> listUsersWithPagination(int pageNo, int usersCount) {
//		Sort sortOrder = Sort.by("id").descending();
		PageRequest pageReq = PageRequest.of(pageNo, usersCount);
//		jpaRepository.findAll(pageReq).forEach(users -> list.add(users));
				return jpaRepository.findAll();
	}

}
