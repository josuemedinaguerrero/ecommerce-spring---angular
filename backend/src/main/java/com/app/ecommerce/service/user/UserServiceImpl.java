package com.app.ecommerce.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.ecommerce.dto.SignUpDTO;
import com.app.ecommerce.dto.UserDTO;
import com.app.ecommerce.entities.User;
import com.app.ecommerce.enums.UserRole;
import com.app.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDTO createUser(SignUpDTO signUpDTO) {
    User user = new User();
    user.setName(signUpDTO.getName());
    user.setEmail(signUpDTO.getEmail());
    user.setUserRole(UserRole.USER);
    user.setPassword(new BCryptPasswordEncoder().encode(signUpDTO.getPassword()));
    userRepository.save(user);
    return user.mapToUserDTO();
  }

  @Override
  public Boolean hasUserWithEmail(String email) {
    return userRepository.findFirstByEmail(email) != null;
  }

}
