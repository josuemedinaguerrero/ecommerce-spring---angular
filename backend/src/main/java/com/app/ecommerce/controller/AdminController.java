package com.app.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.dto.CategoryDTO;
import com.app.ecommerce.entities.Category;
import com.app.ecommerce.service.admin.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

  @Autowired
  private AdminService adminService;

  @PostMapping("/category")
  public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO) {
    Category category = adminService.createCategory(categoryDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(category);
  }

}
