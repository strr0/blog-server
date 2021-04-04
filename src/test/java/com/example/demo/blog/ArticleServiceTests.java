package com.example.demo.blog;

import com.example.demo.blog.entity.Article;
import com.example.demo.blog.entity.query.ArticleQuery;
import com.example.demo.blog.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
class ArticleServiceTests {
    @Autowired
    private ArticleService service;

    @Test
    void listArticlesTest() {
        ArticleQuery articleQuery = new ArticleQuery();
        articleQuery.setState(1);
        articleQuery.setTitle("abc");
        Page<Article> articleQueryPage = service.listArticlesByPage(articleQuery, PageRequest.of(0, 10));
        List<Article> articleQueryList = articleQueryPage.getContent();
        if (articleQueryList.size() > 0) {
            System.out.println(articleQueryList.get(0).getNickname());
        }
        System.out.println(articleQueryPage.getTotalElements());
    }

    @Test
    void getArticleTest() {
        Article article = service.getById(1);
        if (article != null) {
            System.out.println(article.getMdContent());
        }
    }
}
