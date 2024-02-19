package com.app.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecommerce.entities.User;
import com.app.ecommerce.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findFirstByEmail(String email);

  User findByUserRole(UserRole admin);

}
