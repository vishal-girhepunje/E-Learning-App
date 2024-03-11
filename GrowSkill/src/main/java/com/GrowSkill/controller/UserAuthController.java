package com.GrowSkill.controller;

import com.GrowSkill.api.request.JwtAuthenticationRequest;
import com.GrowSkill.api.request.UserCreationRequest;
import com.GrowSkill.service.IUserService;
import com.GrowSkill.service.impl.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/users")
public class UserAuthController {


    @Autowired
    private IUserService userService;

    @PostMapping("/add-users")
    public ResponseEntity<String> userCreation(@RequestBody UserCreationRequest request){
        userService.addUser(request);
        return ResponseEntity.ok("user created Successfully");
    }

    @Autowired
    private IUserAuthService userAuthService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody JwtAuthenticationRequest request){
        return ResponseEntity.ok(userAuthService.authenticate(request));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("You are authenticated");
    }
}
