package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.R;
import com.example.y.mvp.mvp.view.MainView;

/**
 * by 12406 on 2016/5/1.
 */
public class MainViewPresenterImpl implements MainViewPresenter {

    private final MainView mainView;

    public MainViewPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void switchId(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                mainView.switchNews();
                break;
            case R.id.navigation_encyclopedia:
                mainView.switchEncyclopedia();
                break;
            case R.id.navigation_item_image_classification:
                mainView.switchImageClassification();
                break;
            case R.id.navigation_item_new_image:
                mainView.switchNewImage();
                break;
            case R.id.navigation_about:
                mainView.switchAbout();
                break;
        }
    }
}
