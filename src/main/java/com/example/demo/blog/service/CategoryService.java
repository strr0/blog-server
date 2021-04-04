package com.example.demo.blog.service;

import com.example.demo.blog.entity.Category;

import java.util.List;

/**
 * 文章类别逻辑服务
 * @author STRR
 */
public interface CategoryService {
    /**
     * 获取所有类别
     * @return
     */
    List<Category> listCategories();

    /**
     * 添加类别
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 修改类别
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 删除类别
     * @param id
     */
    void deleteById(Integer id);
}
