package com.example.demo.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 文章评论
 */
@Data
@Entity
@Table(name = "blog_comment")
public class Comment {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文章
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 父评论
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 用户
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 发表时间
     */
    @Column(name = "publish_time")
    private LocalDateTime publishTime;
}
