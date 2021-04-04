package com.example.demo.blog.controller;

import com.example.demo.blog.entity.Category;
import com.example.demo.blog.service.CategoryService;
import com.example.demo.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章类别访问控制
 * @author STRR
 */
@RestController
@RequestMapping("/blog/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/listCategories")
    public CommonResult listCategories() {
        try {
            List<Category> categoryList = service.listCategories();
            return CommonResult.success(categoryList);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PostMapping("/saveCategory")
    public CommonResult saveCategory(Category category) {
        try {
            service.saveCategory(category);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PutMapping("/updateCategory")
    public CommonResult updateCategory(Category category) {
        try {
            service.updateCategory(category);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @DeleteMapping("/deleteCategory")
    public CommonResult deleteCategory(Integer id) {
        try {
            if (id != null) {
                service.deleteById(id);
                return CommonResult.success();
            }
            return CommonResult.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }
}
