package com.GrowSkill.api.request;

import com.GrowSkill.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserCreationRequest {
    private String userName;
    private List<Role> roles;
    private String firstName;
    private String lastName;
    private String password;
}
