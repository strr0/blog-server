package com.example.demo.blog.service;

import com.example.demo.blog.entity.Article;
import com.example.demo.blog.entity.query.ArticleQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 文章逻辑服务
 * @author STRR
 */
public interface ArticleService {
    /**
     * 分页获取文章
     * @param articleQuery
     * @param pageable
     * @return
     */
    Page<Article> listArticlesByPage(ArticleQuery articleQuery, Pageable pageable);

    /**
     * 获取文章
     * @param id
     * @return
     */
    Article getById(Integer id);
}
