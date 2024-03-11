package com.GrowSkill.api.request;

import lombok.Data;

@Data
public class JwtAuthenticationRequest {
    private String userName;
    private String password;
}
