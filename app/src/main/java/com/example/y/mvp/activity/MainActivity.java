package com.example.y.mvp.activity;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.MenuItemAdapter;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.fragment.AboutFragment;
import com.example.y.mvp.fragment.ImageNewFragment;
import com.example.y.mvp.fragment.ImageViewPagerFragment;
import com.example.y.mvp.fragment.JokeMainPagerFragment;
import com.example.y.mvp.fragment.NewsViewPagerFragment;
import com.example.y.mvp.fragment.TestFragment;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.MainViewPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.LogUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.utils.rxBindingUtils;
import com.example.y.mvp.utils.theme.ReplaceThemeUtils;
import com.example.y.mvp.utils.theme.SharedPreferencesMgr;
import com.example.y.mvp.utils.theme.widget.ThemeListView;
import com.example.y.mvp.utils.theme.widget.ThemeToolbar;

import butterknife.Bind;

public class MainActivity extends BaseActivity
        implements BaseView.MainView, rxBindingUtils.RxBinding {


    @SuppressWarnings("unused")
    @Bind(R.id.toolBar)
    ThemeToolbar toolBar;
    @SuppressWarnings("unused")
    @Bind(R.id.dl_layout)
    DrawerLayout drawerLayout;
    @SuppressWarnings("unused")
    @Bind(R.id.list_menu)
    ThemeListView listMenu;

    private BasePresenter.MainViewPresenter mainViewPresenter;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        if (SharedPreferencesMgr.getIsNight()) {
            setDay();
        } else {
            setNight();
        }
    }


    private void init() {
        toolBar.setTitle(UIUtils.getString(R.string.list_menu_news));
        setSupportActionBar(toolBar);
        mainViewPresenter = new MainViewPresenterImpl(this);
        mainViewPresenter.rxBus();
        switchNews();
        setUpDrawer();
//        rxBindingUtils.clicks(imageView, this);
    }


    private void setUpDrawer() {
        final MenuItemAdapter adapter = new MenuItemAdapter();
        listMenu.addHeaderView(LayoutInflater.from(this).inflate(R.layout.list_header, listMenu, false));
        listMenu.setAdapter(adapter);
        imageView = (ImageView) listMenu.findViewById(R.id.iv);
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LogUtils.i("____position", position + "");
                if (position!=0){
                    toolBar.setTitle((CharSequence) adapter.getItem(position-1));
                    mainViewPresenter.switchPosition(position);
                    drawerLayout.closeDrawers();
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplaceThemeUtils.theme();
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

    @Override
    public void setDay() {
        imageView.setBackgroundResource(R.drawable.day);
    }

    @Override
    public void setNight() {
        imageView.setBackgroundResource(R.drawable.night);
    }

    @Override
    public void clicks() {
        ReplaceThemeUtils.theme();
    }

}
