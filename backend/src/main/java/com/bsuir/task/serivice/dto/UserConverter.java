package com.bsuir.task.serivice.dto;

import com.bsuir.task.repository.entity.User;

public class UserConverter {
    private UserConverter() {
    }

    public static User fromDTO(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setId(userDTO.getId());
        return user;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
