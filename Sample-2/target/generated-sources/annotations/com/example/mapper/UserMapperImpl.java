package com.example.mapper;

import com.example.model.Address;
import com.example.model.Project;
import com.example.model.User;
import com.example.model.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-23T12:15:39+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto convertUserToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserId( user.getId() );
        userDto.setUserName( user.getName() );
        userDto.setCreatedBy( user.getCreatedBy() );
        userDto.setUpdatedBy( user.getUpdatedBy() );
        userDto.setCreatedOn( user.getCreatedOn() );
        userDto.setUpdatedOn( user.getUpdatedOn() );
        userDto.setRowVersion( user.getRowVersion() );
        userDto.setUserdetails( user.getUserdetails() );
        List<Address> list = user.getAddress();
        if ( list != null ) {
            userDto.setAddress( new ArrayList<Address>( list ) );
        }
        userDto.setRole( user.getRole() );
        List<Project> list1 = user.getProjects();
        if ( list1 != null ) {
            userDto.setProjects( new ArrayList<Project>( list1 ) );
        }

        return userDto;
    }

    @Override
    public User convertDtoToUser(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getUserId() );
        user.setName( dto.getUserName() );
        user.setCreatedBy( dto.getCreatedBy() );
        user.setUpdatedBy( dto.getUpdatedBy() );
        user.setCreatedOn( dto.getCreatedOn() );
        user.setUpdatedOn( dto.getUpdatedOn() );
        user.setRowVersion( dto.getRowVersion() );
        List<Project> list = dto.getProjects();
        if ( list != null ) {
            user.setProjects( new ArrayList<Project>( list ) );
        }
        user.setRole( dto.getRole() );
        user.setUserdetails( dto.getUserdetails() );
        List<Address> list1 = dto.getAddress();
        if ( list1 != null ) {
            user.setAddress( new ArrayList<Address>( list1 ) );
        }

        return user;
    }

    @Override
    public List<UserDto> convertUserToDto(List<User> listUsers) {
        if ( listUsers == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( listUsers.size() );
        for ( User user : listUsers ) {
            list.add( convertUserToDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> convertDtoToUser(List<UserDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtos.size() );
        for ( UserDto userDto : dtos ) {
            list.add( convertDtoToUser( userDto ) );
        }

        return list;
    }
}
