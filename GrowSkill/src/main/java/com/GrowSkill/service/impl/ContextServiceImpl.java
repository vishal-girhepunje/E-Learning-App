package com.GrowSkill.service.impl;

import com.GrowSkill.Repository.IUserRepository;
import com.GrowSkill.model.User;
import com.GrowSkill.service.IContextService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ContextServiceImpl implements IContextService {

    private IUserRepository userRepository;
    @Override
    public User getCurrentUser() {
        String userName = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUserName(userName);
    }
}
