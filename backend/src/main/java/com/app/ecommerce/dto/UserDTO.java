package com.app.ecommerce.dto;

import com.app.ecommerce.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

  private Long id;
  private String name;
  private String password;
  private String email;
  private UserRole userRole;

}
