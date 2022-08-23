package com.example.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.model.User;
import com.example.model.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(source = "id", target = "userId")
	@Mapping(source = "name", target = "userName")
	UserDto convertUserToDto(User user);

	@Mapping(source = "userId", target = "id")
	@Mapping(source = "userName", target = "name")
	User convertDtoToUser(UserDto dto);

	@Mapping(source = "id", target = "userId")
	@Mapping(source = "name", target = "userName")
	List<UserDto> convertUserToDto(List<User> listUsers);

	@Mapping(source = "userId", target = "id")
	@Mapping(source = "userName", target = "name")
	List<User> convertDtoToUser(List<UserDto> dtos);

}
