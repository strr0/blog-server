package com.example.demo.blog.controller;

import com.example.demo.blog.entity.Article;
import com.example.demo.blog.entity.query.ArticleQuery;
import com.example.demo.blog.service.ArticleService;
import com.example.demo.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章访问控制
 * @author STRR
 */
@RestController
@RequestMapping("/blog/article")
public class ArticleController {
    @Autowired
    private ArticleService service;

    @GetMapping("/listArticlesByPage")
    public CommonResult listArticlesByPage(ArticleQuery articleQuery, Pageable pageable) {
        try {
            Page<Article> articlePage = service.listArticlesByPage(articleQuery, pageable);
            return CommonResult.success(articlePage);
        } catch (Exception e) {
            return CommonResult.fail();
        }
    }

    @GetMapping("/{id}")
    public CommonResult getArticleById(@PathVariable Integer id) {
        try {
            Article article = service.getById(id);
            return CommonResult.success(article);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }
}
