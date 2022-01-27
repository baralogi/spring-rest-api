package com.ssembara.springnews.presist.services;

import java.util.List;
import java.util.Optional;

import com.ssembara.springnews.application.request.v1.category.CategoryStore;
import com.ssembara.springnews.application.request.v1.category.CategoryUpdate;
import com.ssembara.springnews.presist.models.Category;
import com.ssembara.springnews.presist.repositories.CategoryRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository repo;

    public List<Category> getAll() {
        return repo.findAll();
    }

    public void storeCategory(CategoryStore storeCategory) {
        var newCategory = new Category();
        newCategory.setName(storeCategory.getName());

        repo.save(newCategory);
    }

    public Optional<Category> showCategory(Long id) throws Exception {
        return repo.findById(id);
    }

    public void updateCategory(Long id, CategoryUpdate updateCategory) throws Exception {
        var oldCategory = repo.findById(id).orElseThrow(() -> new Exception("data not found"));
        oldCategory.setName(updateCategory.getName());

        repo.save(oldCategory);
    }

    public void destroyCategory(Long id) throws Exception {
        repo.deleteById(id);
    }
}
