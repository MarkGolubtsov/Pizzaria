package com.bsuir.task.serivice;

import com.bsuir.task.serivice.dto.UserDTO;

public interface UserService {
    UserDTO findByEmailAndPassword(String email, String password);

    UserDTO findByEmail(String email);
}
