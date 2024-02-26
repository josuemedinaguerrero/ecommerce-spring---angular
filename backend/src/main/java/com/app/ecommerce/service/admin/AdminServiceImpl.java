package com.app.ecommerce.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ecommerce.dto.CategoryDTO;
import com.app.ecommerce.entities.Category;
import com.app.ecommerce.repository.CategoryRepository;

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Category createCategory(CategoryDTO categoryDTO) {
    Category category = new Category();
    category.setName(categoryDTO.getName());
    category.setDescription(categoryDTO.getDescription());
    return categoryRepository.save(category);
  }

}
