package com.app.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.dto.SignUpDTO;
import com.app.ecommerce.dto.UserDTO;
import com.app.ecommerce.service.user.UserService;

@RestController
public class SignUpController {

  @Autowired
  private UserService userService;

  @PostMapping("/sign-up")
  public ResponseEntity<?> signupUser(@RequestBody SignUpDTO signUpDTO) {
    if (userService.hasUserWithEmail(signUpDTO.getEmail())) {
      return new ResponseEntity<>("User already exist", HttpStatus.NOT_ACCEPTABLE);
    }

    UserDTO createdUser = userService.createUser(signUpDTO);

    if (createdUser == null) {
      return new ResponseEntity<>("User not created. Come again later!", HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }

}
