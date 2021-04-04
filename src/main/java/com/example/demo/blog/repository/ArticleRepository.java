package com.example.demo.blog.repository;

import com.example.demo.blog.entity.Article;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 文章数据访问
 * @author STRR
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    /**
     * 文章条件查询及分页
     * @param example
     * @param pageable
     * @return
     */
    @Override
    @EntityGraph(value = "article.all", type = EntityGraphType.FETCH)
    Page<Article> findAll(Example example, Pageable pageable);

    /**
     * 获取文章
     * @param id
     * @return
     */
    @Override
    @EntityGraph(value = "article.all", type = EntityGraphType.FETCH)
    Article getOne(Integer id);
}
