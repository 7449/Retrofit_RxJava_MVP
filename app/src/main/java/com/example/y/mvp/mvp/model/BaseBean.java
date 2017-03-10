package com.example.y.mvp.mvp.model;

import java.util.List;

/**
 * by y on 2016/5/27.
 */

public class BaseBean<M> {

    private List<M> tngou;

    public List<M> getTngou() {
        return tngou;
    }

    public void setTngou(List<M> tngou) {
        this.tngou = tngou;
    }

    public class TabNewsBean extends BaseBean<TabNewsInfo> {
    }

    public class TabNameBean extends BaseBean<TabNameInfo> {
    }

    public class ImageListBean extends BaseBean<ImageListInfo> {
    }

    public class ImageNewBean extends BaseBean<ImageNewInfo> {
    }

    public class NewsListBean extends BaseBean<NewsListInfo> {
    }

    public class ImageDetailBean {
        private List<ImageDetailInfo> list;

        public List<ImageDetailInfo> getList() {
            return list;
        }

        public void setList(List<ImageDetailInfo> list) {
            this.list = list;
        }

    }

}
