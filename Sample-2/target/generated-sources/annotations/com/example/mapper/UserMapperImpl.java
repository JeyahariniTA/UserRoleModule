package com.example.mapper;

import com.example.model.User;
import com.example.model.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T11:13:51+0530",
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

        return userDto;
    }

    @Override
    public User converDtoToUser(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getUserId() );
        user.setName( dto.getUserName() );

        return user;
    }

    @Override
    public List<User> convertUserToDto(List<User> listUsers) {
        if ( listUsers == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( listUsers.size() );
        for ( User user : listUsers ) {
            list.add( user );
        }

        return list;
    }
}
