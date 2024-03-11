package com.GrowSkill.service.impl;

import com.GrowSkill.Repository.IUserRepository;
import com.GrowSkill.api.request.JwtAuthenticationRequest;
import com.GrowSkill.api.response.JwtAuthenticationResponse;
import com.GrowSkill.exception.BadRequestException;
import com.GrowSkill.model.User;
import com.GrowSkill.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAuthServiceImpl implements IUserAuthService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public JwtAuthenticationResponse authenticate(JwtAuthenticationRequest request) {
        User user = userRepository.findByUserName(request.getUserName());
        if (!passwordEncoder.matches(request.getPassword(),user.getPassword())) {
            throw new BadRequestException("Incorrect UserName or Password");
        }
        return new
                JwtAuthenticationResponse(jwtTokenUtil.generateToken(user, null));

    }
}
