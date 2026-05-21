package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserSecurity;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserSecurity userSecurity;

    public UserController(UserRepository userRepository, UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, UserSecurity userSecurity) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userSecurity = userSecurity;
    }
@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String,String> body ){
         String firstName=body.get("firstName");
         String lastName= body.get("lastName");
         String email=body.get("email");
         String mobileNumber=body.get("mobileNumber");
         String gender=body.get("gender");
         String dateOfBirth=body.get("dateOfBirth");
         String password=passwordEncoder.encode(body.get("password"));

         if(userRepository.findByEmail(email).isPresent()){
             return new ResponseEntity<>("User Already Exists", HttpStatus.ALREADY_REPORTED);
         }
     userService.createUser(User.builder()
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .mobileNumber(mobileNumber)
            .gender(gender)
            .dateOfBirth(dateOfBirth)
            .password(password)
            .build());
    return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);

    }
@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String , String> body){
    String email= body.get("email");
    String password= body.get("password");

    var userOptional= userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
        return new ResponseEntity<>("User not Registered ",HttpStatus.NOT_FOUND);
    }
    User user=userOptional.get();
        if(!passwordEncoder.matches(password,user.getPassword())){
        return new ResponseEntity<>("InCorrect Password",HttpStatus.UNAUTHORIZED);
    }
    String token = jwtUtil.generateToken(email);
    return ResponseEntity.ok(Map.of(
            "message",    "Login Successful",
            "email",      email,
            "firstName",  user.getFirstName(),
            "token",      token
    ));
}

}
