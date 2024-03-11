package com.GrowSkill.service.impl;

import com.GrowSkill.api.request.JwtAuthenticationRequest;
import com.GrowSkill.api.response.JwtAuthenticationResponse;

public interface IUserAuthService {
    public JwtAuthenticationResponse authenticate(JwtAuthenticationRequest request);
}
