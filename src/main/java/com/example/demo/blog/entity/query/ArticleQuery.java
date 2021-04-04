package com.example.demo.blog.entity.query;

/**
 * 文章
 * @author STRR
 */
public class ArticleQuery {
    /**
     * 标题
     */
    private String title;

    /**
     * 状态 (0草稿, 1发表, 2删除)
     */
    private Integer state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
