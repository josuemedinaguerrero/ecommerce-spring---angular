package com.app.ecommerce.entities;

import com.app.ecommerce.dto.UserDTO;
import com.app.ecommerce.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String password;
  private String email;
  private UserRole userRole;
  private byte[] img;

  public UserDTO mapToUserDTO() {
    return new UserDTO(id, name, password, email, userRole);
  }

}
