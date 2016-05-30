package com.example.y.mvp.mvp.Bean;

import java.util.List;

/**
 * by y on 2016/5/30.
 */
@SuppressWarnings("ALL")
public class JokeTextBean {

    private String showapi_res_code;
    private String showapi_res_error;
    private JokeText showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public JokeText getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(JokeText showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public String getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(String showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }


    public class JokeText {

        private String allNum;
        private String allPages;
        private List<JokeTextInfo> contentlist;

        public List<JokeTextInfo> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<JokeTextInfo> contentlist) {
            this.contentlist = contentlist;
        }

        public String getAllPages() {
            return allPages;
        }

        public void setAllPages(String allPages) {
            this.allPages = allPages;
        }

        public String getAllNum() {
            return allNum;
        }

        public void setAllNum(String allNum) {
            this.allNum = allNum;
        }


    }

    public class JokeTextInfo {
        private String ct;
        private String id;
        private String text;
        private String title;
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCt() {
            return ct;
        }

        public void setCt(String ct) {
            this.ct = ct;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

}
