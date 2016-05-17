package com.example.y.mvp.mvp.Bean;

import java.util.List;

/**
 * by y on 2016/5/11.
 */
@SuppressWarnings("ALL")
public class EncyclopediaBean {


    private String total;


    private String status;


    private List<EncyclopediaInfo> tngou;

    public List<EncyclopediaInfo> getTngou() {
        return tngou;
    }

    public void setTngou(List<EncyclopediaInfo> tngou) {
        this.tngou = tngou;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
