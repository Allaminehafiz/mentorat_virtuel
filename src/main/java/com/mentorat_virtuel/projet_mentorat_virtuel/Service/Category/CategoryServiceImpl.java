package com.mentorat_virtuel.projet_mentorat_virtuel.Service.Category;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Category;
import com.mentorat_virtuel.projet_mentorat_virtuel.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;


    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public List<Category> getAllCategoryByid() {
        return List.of();
    }

    @Override
    public Category getCategoryByid(Long id) {
        return null;
    }

    @Override
    public Category updateCategoryByid(Category category, Long id) {
        return null;
    }

    @Override
    public void deleteCategoryByid(Long id) {

    }
}
