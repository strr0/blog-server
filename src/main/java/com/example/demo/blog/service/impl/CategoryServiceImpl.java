package com.example.demo.blog.service.impl;

import com.example.demo.blog.entity.Category;
import com.example.demo.blog.repository.CategoryRepository;
import com.example.demo.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章类别逻辑服务实现
 * @author STRR
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> listCategories() {
        return repository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        repository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        repository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
