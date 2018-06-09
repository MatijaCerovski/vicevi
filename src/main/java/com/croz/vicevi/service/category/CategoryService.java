package com.croz.vicevi.service.category;

import com.croz.vicevi.persistence.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category findByName(String name);
    List<Category> findAll();
    Category findById(Integer id);
    Category save(Category category);
}
