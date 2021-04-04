package com.example.demo.blog.repository;

import com.example.demo.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 文章类别数据访问
 * @author STRR
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
