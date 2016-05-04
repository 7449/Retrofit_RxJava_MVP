package com.example.y.mvp.mvp.Bean;

/**
 * by y on 2016/4/29.
 */
@SuppressWarnings("ALL")
public class ImageDetailInfo {


    private int id;
    private int gallery; //图片库
    private String src; //图片地址


    public int getGallery() {
        return gallery;
    }

    public void setGallery(int gallery) {
        this.gallery = gallery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}
