package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.JokeTextBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by y on 2016/5/30.
 */
public class JokeTextModeImpl implements BaseModel.JokeTextListModel {

    @Override
    public void netWorkJoke(int page, final BaseDataBridge.JokeTextList jokeList) {

        NetWorkRequest.jokeTextList(page, new MySubscriber<JokeTextBean>() {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                jokeList.error();
            }

            @Override
            public void onNext(JokeTextBean jokeTextBean) {
                super.onNext(jokeTextBean);
                jokeList.addData(jokeTextBean.getShowapi_res_body().getContentlist());
            }
        });

    }
}
