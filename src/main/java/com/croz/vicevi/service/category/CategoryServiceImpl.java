package com.croz.vicevi.service.category;

import com.croz.vicevi.persistence.model.Category;
import com.croz.vicevi.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findByName(String name) {
        if(name == null){
            return null;
        }
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) throws EntityNotFoundException{

        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            return category.get();
        }else{
            throw new EntityNotFoundException();
        }

    }

    @Override
    public Category save(Category category) {
        if(category == null){
            return null;
        }
        return categoryRepository.save(category);
    }


}
