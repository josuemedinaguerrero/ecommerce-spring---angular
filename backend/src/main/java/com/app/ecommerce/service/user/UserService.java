package com.app.ecommerce.service.user;

import com.app.ecommerce.dto.SignUpDTO;
import com.app.ecommerce.dto.UserDTO;

public interface UserService {

  UserDTO createUser(SignUpDTO signUpDTO);

  Boolean hasUserWithEmail(String email);

  void createAdminAccount();

}
