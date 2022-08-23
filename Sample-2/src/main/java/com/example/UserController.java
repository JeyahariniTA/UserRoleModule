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
	public List<UserDto> getUsers() {
		return dao.listUsers();
	}

	@GetMapping(path = "/get/{userId}")
	@ResponseBody
	public UserDto getUserById(@PathVariable("userId") int userId) {
		return dao.getUserById(userId);
	}

	@GetMapping(path = "/get/{pageNo}/{userCount}")
	@ResponseBody
	public List<UserDto> getUsersWithPagination(@PathVariable("pageNo") int pageNo,
			@PathVariable("userCount") int userCount) {
		return dao.listUsersWithPagination(pageNo, userCount);
	}

	@PostMapping(path = "/add")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		if (null != user.getUserdetails() && null != user.getUserdetails().getDob()) {
			boolean isValidDate = false;
			String dob = user.getUserdetails().getDob();
			String regex = "^([0-9]{4})-(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])$";
			isValidDate = dob.matches(regex);

			if (isValidDate) {
				UserDto userDto = dao.addUser(user);
				if (userDto.getUserId() == 0) {
					throw new CustomException("User not exists", HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<>(userDto, HttpStatus.OK);
				}
			} else {
//			userDto.setError("Entry not added. Please provide valid date format - (yyyy-mm-dd)");
				// if (userDto.getId() != 0) {
//			throw new CustomBadRequestException("Entry not added. Please provide valid date format - (yyyy-mm-dd)");
				throw new CustomException("Entry not added. Please provide valid date format - (yyyy-mm-dd)",
						HttpStatus.BAD_REQUEST);
				// }
			}
		} else {
			UserDto userDto = dao.addUser(user);
			if (userDto.getUserId() == 0) {
				throw new CustomException("User not exists", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(userDto, HttpStatus.OK);
			}
		}
	}

	@DeleteMapping(path = "/delete/{userId}")
	public String deleteUser(@PathVariable("userId") int userId) {
		return dao.deleteUser(userId);

	}

	@PutMapping(path = "/update")
	public ResponseEntity<Object> updateUserById(@RequestBody User user) {
		if (null != user.getUserdetails() && null != user.getUserdetails().getDob()) {
			boolean isValidDate = false;
			String dob = user.getUserdetails().getDob();
			String regex = "^([0-9]{4})-(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])$";
			isValidDate = dob.matches(regex);
			UserDto userDto;
			if (isValidDate) {
				userDto = dao.updateById(user);
				if (userDto.getUserId() == 0) {
					throw new CustomException("User not exists", HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<>(userDto, HttpStatus.OK);
				}
			} else {
//			userDto.setError("Entry not added. Please provide valid date format - (yyyy-mm-dd)");
				// if (userDto.getId() != 0) {
//			throw new CustomBadRequestException("Entry not added. Please provide valid date format - (yyyy-mm-dd)");
				throw new CustomException("Entry not added. Please provide valid date format - (yyyy-mm-dd)",
						HttpStatus.BAD_REQUEST);
				// }
			}
		} else {
			UserDto userDto = dao.updateById(user);
			if (userDto.getUserId() == 0) {
				throw new CustomException("User not exists", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(userDto, HttpStatus.OK);
			}
		}
	}

	@GetMapping(path = "/getByRoleId/{roleId}")
	@ResponseBody
	public List<UserDto> getUsersByRoleId(@PathVariable("roleId") int roleId) {
		List<UserDto> userDtos = dao.getUsersByRoleId(roleId);
		return userDtos;
	}

	/*
	 * @GetMapping(path = "/findRolesByUserId/{userId}") public
	 * ResponseEntity<Object> findRolesByUserId(@PathVariable("userId") int userId)
	 * { RoleDto roleDto = dao.getRoleByUserId(userId); return new
	 * ResponseEntity<>(roleDto, HttpStatus.OK); }
	 */
}
