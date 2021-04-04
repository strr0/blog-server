package com.example.demo.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 文章类别
 * @author STRR
 */
@Data
@Entity
@Table(name = "blog_category")
public class Category {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类别名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 时间
     */
    @Column(name = "time")
    private LocalDateTime time;
}
