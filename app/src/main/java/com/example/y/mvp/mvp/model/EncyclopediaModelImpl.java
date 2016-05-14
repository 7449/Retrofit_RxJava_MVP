package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.EncyclopediaBean;
import com.example.y.mvp.mvp.Bean.EncyclopediaInfo;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

import java.util.List;

/**
 * by y on 2016/5/11.
 */
public class EncyclopediaModelImpl implements EncyclopediaModel {

    @Override
    public void netWorkEncyclopedia(String keyword, int page, final EncycloedData encycloedData) {
        
        NetWorkRequest.encyclopedia(keyword, page, new MySubscriber<EncyclopediaBean>() {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                encycloedData.error();
            }

            @Override
            public void onNext(EncyclopediaBean encyclopediaBean) {
                super.onNext(encyclopediaBean);
                encycloedData.addData(encyclopediaBean.getTngou());
            }
        });
    }


    public interface EncycloedData {

        void addData(List<EncyclopediaInfo> encyclopediaInfo);

        void error();
    }
}
