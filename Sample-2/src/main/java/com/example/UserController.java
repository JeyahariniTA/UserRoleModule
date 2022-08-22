package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.CustomException;
import com.example.mapper.UserMapper;
import com.example.model.Role;
import com.example.model.User;
import com.example.model.UserDto;
import com.example.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	UserService dao;

	@Autowired
	UserMapper userMapper;

	@GetMapping(path = "/Hello")
	@ResponseBody
	public String sayHello() {
		return "Hello!";
	}

	@GetMapping(path = "/get")
	@ResponseBody
	public List<User> getUsers() {
		return userMapper.convertUserToDto(dao.listUsers());
	}

	@GetMapping(path = "/get/{userId}")
	@ResponseBody
	public UserDto getUserById(@PathVariable("userId") int userId) {
		return userMapper.convertUserToDto(dao.getUserById(userId));
	}
	
//	@GetMapping(path = "/get/{pageNo}/{userCount}")
//	@ResponseBody
//	public UserDto getUsersWithPagination(@PathVariable("pageNo") int pageNo, @PathVariable("userCount") int userCount) {
//		return userMapper.convertUserToDto(dao.getUserById(userId));
//	}

	@PostMapping(path = "/add")
	public User addUser(@RequestBody User user) {
		String dob = user.getUserdetails().getDob();
		// System.out.println("date: " + dob);
		String regex = "^([0-9]{4})-(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])$";
		boolean isValidDate = dob.matches(regex);
		if (isValidDate && !dob.isEmpty()) {
			// System.out.println("matches");
			return dao.addUser(user);
		} else {
			user.setError("Entry not added. Please provide valid date format - (yyyy-mm-dd)");
			return user;
		}
	}

	@DeleteMapping(path = "/delete/{userId}")
	public String deleteUser(@PathVariable("userId") int userId) {
		return dao.deleteUser(userId);

	}

	@PutMapping(path = "/update")
	public ResponseEntity<Object> updateUserById(@RequestBody User userDto) {
		boolean isValidDate = false;
		String dob = userDto.getUserdetails().getDob();
		String regex = "^([0-9]{4})-(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])$";
		isValidDate = dob.matches(regex);

		if (isValidDate) {
			userDto = dao.updateById(userDto);
			if (userDto.getId() == 0) {
				throw new CustomException("User not exists", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(userDto, HttpStatus.OK);
			}
		} else {
			userDto.setError("Entry not added. Please provide valid date format - (yyyy-mm-dd)");
			// if (userDto.getId() != 0) {
//			throw new CustomBadRequestException("Entry not added. Please provide valid date format - (yyyy-mm-dd)");
			throw new CustomException("Entry not added. Please provide valid date format - (yyyy-mm-dd)",
					HttpStatus.BAD_REQUEST);
			// }
		}
	}

	@GetMapping(path = "/getByRoleId/{roleId}")
	@ResponseBody
	public List<User> getUsersByRoleId(@PathVariable("roleId") int roleId) {
		List<User> users = dao.getUsersByRoleId(roleId);
		return users;
	}

	@GetMapping(path = "/findRolesByUserId/{userId}")
	public List<Role> findRolesByUserId(@PathVariable("userId") int userId) {
		return dao.getRolesByUserId(userId);
	}
}
