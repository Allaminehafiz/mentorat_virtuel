package com.mentorat_virtuel.projet_mentorat_virtuel.Service.Category;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory (Category category);
    List<Category> getAllCategoryByid ();
    Category getCategoryByid (Long id);
    Category updateCategoryByid (Category category, Long id);
    void deleteCategoryByid (Long id);
}
