package com.example.y.mvp.mvp.Bean;

/**
 * by y on 2016/5/11.
 */
public class EncyclopediaInfo {

    private long id;  //ID标记
    private String title;//标题
    private String description;//描述
    private String keywords;//关键字
    private String message;//资讯内容
    private String img; //内容里面的图片
    private String url; //内容对应的URL地址
    private String type;// 索引类型

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
