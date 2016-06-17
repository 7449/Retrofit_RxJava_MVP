package com.example.y.mvp.activity;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.y.mvp.R;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.fragment.AboutFragment;
import com.example.y.mvp.fragment.ImageNewFragment;
import com.example.y.mvp.fragment.ImageViewPagerFragment;
import com.example.y.mvp.fragment.JokeMainPagerFragment;
import com.example.y.mvp.fragment.NewsViewPagerFragment;
import com.example.y.mvp.fragment.TestFragment;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.MainViewPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.UIUtils;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements BaseView.MainView {

    @SuppressWarnings("unused")
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @SuppressWarnings("unused")
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @SuppressWarnings("unused")
    @Bind(R.id.dl_layout)
    DrawerLayout drawerLayout;
    private BasePresenter.MainViewPresenter mainViewPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }


    private void init() {
        toolBar.setTitle(UIUtils.getString(R.string.navigation_news));
        setSupportActionBar(toolBar);
        setupDrawerContent(navigationView);
        mainViewPresenter = new MainViewPresenterImpl(this);
        switchNews();
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        toolBar.setTitle(menuItem.getTitle());
                        mainViewPresenter.switchId(menuItem.getItemId());
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (Constant.BACK_EXIT) {
                super.onBackPressed();
                return;
            }
            Constant.BACK_EXIT = true;
            Toast(UIUtils.getString(R.string.exit_app));
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Constant.BACK_EXIT = false;
                }
            }, 2000);
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void switchNews() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new NewsViewPagerFragment()).commit();
    }

    @Override
    public void switchImageClassification() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new ImageViewPagerFragment()).commit();
    }

    @Override
    public void switchNewImage() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new ImageNewFragment()).commit();
    }

    @Override
    public void switchJoke() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new JokeMainPagerFragment()).commit();
    }

    @Override
    public void switchAbout() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new AboutFragment()).commit();
    }

    @Override
    public void switchTest() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new TestFragment()).commit();
    }


}
