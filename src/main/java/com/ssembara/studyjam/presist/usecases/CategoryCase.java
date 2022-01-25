package com.ssembara.studyjam.presist.usecases;

import java.util.List;

import com.ssembara.studyjam.application.request.v1.category.CategoryStore;
import com.ssembara.studyjam.application.request.v1.category.CategoryUpdate;
import com.ssembara.studyjam.presist.models.Category;
import com.ssembara.studyjam.presist.repos.CategoryRepo;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryCase {

    private CategoryRepo repo;

    public List<Category> getAll() {
        return repo.findAll();
    }

    public void createCategory(CategoryStore store) {
        var newCategory = new Category();
        newCategory.setName(store.getName());

        repo.save(newCategory);
    }

    public void updateCategory(Long id, CategoryUpdate update) throws Exception {
        var oldCategory = repo.findById(id).orElseThrow(() -> new Exception("data not found"));
        oldCategory.setName(update.getName());

        repo.save(oldCategory);
    }

    public void destroyCategory(Long id) throws Exception {
        repo.deleteById(id);
    }
}
