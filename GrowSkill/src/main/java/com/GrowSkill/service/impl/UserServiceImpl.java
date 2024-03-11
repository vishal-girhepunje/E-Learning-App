package com.GrowSkill.service.impl;


import com.GrowSkill.Repository.IUserRepository;
import com.GrowSkill.api.request.UserCreationRequest;
import com.GrowSkill.exception.BadRequestException;
import com.GrowSkill.model.User;
import com.GrowSkill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserCreationRequest request) {
        User user = userRepository.findByUserName(request.getUserName());
        if(user!=null) throw new BadRequestException("User Name Already Exist");
        User newUser = new User();
        newUser.setRoles(new HashSet<>(request.getRoles()));
        newUser.setUserName(request.getUserName());
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(newUser);
    }

    @Override
    public void updateUser(String uid) {

    }

    @Override
    public void deleteUser(String uid) {

    }

    @Override
    public void disableUser(String uid) {

    }
}
