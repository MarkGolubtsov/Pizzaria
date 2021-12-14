package com.bsuir.task.serivice.impl;

import com.bsuir.task.repository.UserRepository;
import com.bsuir.task.repository.entity.User;
import com.bsuir.task.serivice.UserService;
import com.bsuir.task.serivice.dto.UserConverter;
import com.bsuir.task.serivice.dto.UserDTO;
import com.bsuir.task.serivice.exception.NotFoundEntityException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final String NOT_FOUND = "User not found.";
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findByEmailAndPassword(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(email, password);
        if (optionalUser.isPresent()) {
            return UserConverter.toDTO(optionalUser.get());
        }
        throw new NotFoundEntityException(NOT_FOUND);
    }

    @Override
    public UserDTO findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return UserConverter.toDTO(optionalUser.get());
        }
        throw new NotFoundEntityException(NOT_FOUND);
    }
}
