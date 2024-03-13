package com.legacy.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.legacy.model.entities.User;
import com.legacy.model.entities.DTO.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(expression = "java(user.getFirstName() + \" \" + user.getLastName())", target = "name")
    UserDTO userToUserDTO(User user);
    
    List<UserDTO> usersToUserDTOs(List<User> users);
}