package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.data.IsNightMode;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.RxBus;
import com.example.y.mvp.utils.LogUtils;

import rx.functions.Action1;

/**
 * by 12406 on 2016/5/1.
 */
public class MainViewPresenterImpl extends BasePresenterImpl<BaseView.MainView>
        implements BasePresenter.MainViewPresenter {

    private static final String TAG = "MainViewPresenterImpl---->";

    public MainViewPresenterImpl(BaseView.MainView view) {
        super(view);
    }

    @Override
    public void switchPosition(int position) {

        switch (position){
            case 1:
                view.switchNews();
                break;
            case 2:
                view.switchImageClassification();
                break;
            case 3:
                view.switchNewImage();
                break;
            case 4:
                view.switchJoke();
                break;
            case 5:
                view.switchAbout();
                break;
            case 6:
                view.switchTest();
                break;
        }
    }

    @Override
    public void rxBus() {
        RxBus.getInstance().toObserverable(IsNightMode.class).subscribe(new Action1<IsNightMode>() {
            @Override
            public void call(IsNightMode isNightMode) {

                LogUtils.i(TAG, isNightMode.isNightMode() + "");

                if (isNightMode.isNightMode()) {
                    view.setDay();
                } else {
                    view.setNight();
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                LogUtils.i(TAG, throwable.getMessage());
            }
        });
    }
}
