package com.example.demo.blog.entity;

import com.example.demo.system.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 文章
 * @author STRR
 */
@Entity
@Table(name = "blog_article")
@NamedEntityGraph(name = "article.all",
        attributeNodes = {@NamedAttributeNode("category"), @NamedAttributeNode("user")})
public class Article {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * md文件源码
     */
    @Column(name = "md_content")
    private String mdContent;

    /**
     * html文件源码
     */
    @Column(name = "html_content")
    private String htmlContent;

    /**
     * 总结
     */
    @Column(name = "summary")
    private String summary;

    /**
     * 类别
     */
    @Column(name = "category_id")
    private Integer categoryId;

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

    /**
     * 编辑时间
     */
    @Column(name = "edit_time")
    private LocalDateTime editTime;

    /**
     * 状态 (0草稿, 1发表, 2删除)
     */
    @Column(name = "state")
    private Integer state;

    /**
     * 类别
     */
    @JsonIgnore
    @OneToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;

    /**
     * 类别名称
     */
    @Transient
    private String categoryName;

    /**
     * 用户
     */
    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    /**
     * 用户昵称
     */
    @Transient
    private String nickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryName() {
        if (category != null) {
            return category.getName();
        }
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNickname() {
        if (user != null) {
            return user.getNickname();
        }
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
