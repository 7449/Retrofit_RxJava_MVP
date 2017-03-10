package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.view.BaseView;

/**
 * by 12406 on 2016/5/1.
 */
public class MainViewPresenterImpl
        implements Presenter.MainViewPresenter {

    private final BaseView.MainView mainView;


    public MainViewPresenterImpl(BaseView.MainView view) {
        this.mainView = view;
    }

    @Override
    public void switchPosition(int position) {
        switch (position) {
            case 0:
                mainView.switchNews();
                break;
            case 1:
                mainView.switchImageClassification();
                break;
            case 2:
                mainView.switchNewImage();
                break;
            case 3:
                mainView.switchAbout();
                break;
        }
    }

}
