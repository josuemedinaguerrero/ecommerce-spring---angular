package com.app.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecommerce.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findFirstByEmail(String email);

}
