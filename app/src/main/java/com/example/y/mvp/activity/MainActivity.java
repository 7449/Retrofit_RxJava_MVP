package com.example.y.mvp.activity;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.y.mvp.App;
import com.example.y.mvp.R;
import com.example.y.mvp.adapter.MenuAdapter;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.fragment.AboutFragment;
import com.example.y.mvp.fragment.ImageNewFragment;
import com.example.y.mvp.fragment.ImageViewPagerFragment;
import com.example.y.mvp.fragment.NewsViewPagerFragment;
import com.example.y.mvp.mvp.presenter.MainViewPresenterImpl;
import com.example.y.mvp.mvp.presenter.Presenter;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.StatusBarUtil;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.DarkViewActivity;
import com.example.y.mvp.widget.MRecyclerView;

public class MainActivity extends DarkViewActivity
        implements BaseView.MainView, MenuAdapter.OnItemClickListener {


    private Toolbar toolBar;
    private DrawerLayout drawerLayout;
    private MRecyclerView recyclerViewMenu;

    private Presenter.MainViewPresenter mainViewPresenter;

    @Override
    protected void initCreate(Bundle savedInstanceState) {
        toolBar.setTitle(UIUtils.getString(R.string.list_menu_news));
        setSupportActionBar(toolBar);
        StatusBarUtil.setColorForDrawerLayout(this, drawerLayout, 0);
        mainViewPresenter = new MainViewPresenterImpl(this);
        setUpDrawer();
        init();
    }

    @Override
    protected void initById() {
        toolBar = getView(R.id.toolBar);
        drawerLayout = getView(R.id.dl_layout);
        recyclerViewMenu = getView(R.id.recyclerView_menu);
    }

    private void init() {
        setSwipeBackEnable(false);
        switchNews();
    }


    private void setUpDrawer() {
        MenuAdapter adapter = new MenuAdapter();
        recyclerViewMenu.setHasFixedSize(true);
        recyclerViewMenu.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, StaggeredGridLayoutManager.VERTICAL));
        recyclerViewMenu.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (Constant.BACK_EXIT) {
                super.onBackPressed();
                App.getInstance().exit();
                return;
            }
            Constant.BACK_EXIT = true;
            ActivityUtils.Toast(UIUtils.getString(R.string.exit_app));
            new Handler().postDelayed(() -> Constant.BACK_EXIT = false, 2000);
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void switchNews() {
        getFragment(new NewsViewPagerFragment());
    }


    @Override
    public void switchImageClassification() {
        getFragment(new ImageViewPagerFragment());
    }

    @Override
    public void switchNewImage() {
        getFragment(new ImageNewFragment());
    }

    @Override
    public void switchAbout() {
        getFragment(new AboutFragment());
    }


    private int getFragment(Fragment fragment) {
        return getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
    }

    @Override
    public void onclickItem(View view, int position, String data) {
        toolBar.setTitle(data);
        mainViewPresenter.switchPosition(position);
        drawerLayout.closeDrawers();
    }
}
