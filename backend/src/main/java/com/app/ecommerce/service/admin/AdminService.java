package com.app.ecommerce.service.admin;

import com.app.ecommerce.dto.CategoryDTO;
import com.app.ecommerce.entities.Category;

public interface AdminService {

  Category createCategory(CategoryDTO categoryDTO);

}
