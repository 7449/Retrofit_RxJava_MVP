package com.example.y.mvp.mvp.Bean;

/**
 * by 12406 on 2016/5/15.
 */
@SuppressWarnings("ALL")
public class NewsDetailBean {

    private int count;//访问次数
    private String description;//描述
    private int fcount;//收藏数
    private String fromname;
    private String img;//图片
    private String keywords;//关键字
    private String message;//资讯内容
    private int rcount;//评论读数
    private String title;//资讯标题
    private int topclass;//一级分类
    private String fromurl;
    private Long time;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTopclass() {
        return topclass;
    }

    public void setTopclass(int topclass) {
        this.topclass = topclass;
    }

    public String getFromurl() {
        return fromurl;
    }

    public void setFromurl(String fromurl) {
        this.fromurl = fromurl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
