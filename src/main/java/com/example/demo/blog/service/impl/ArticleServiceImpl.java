package com.example.demo.blog.service.impl;

import com.example.demo.blog.entity.Article;
import com.example.demo.blog.entity.query.ArticleQuery;
import com.example.demo.blog.repository.ArticleRepository;
import com.example.demo.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 文章逻辑服务实现
 * @author STRR
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository repository;

    @Override
    public Page<Article> listArticlesByPage(ArticleQuery articleQuery, Pageable pageable) {
        Article article = new Article();
        article.setTitle(articleQuery.getTitle());
        article.setState(articleQuery.getState());
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("title", m1 -> m1.contains());
        Example<Article> example = Example.of(article, matcher);
        return repository.findAll(example, pageable);
    }

    @Override
    public Article getById(Integer id) {
        return repository.getOne(id);
    }
}
