package com.example.y.mvp.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.TabJokeAdapter;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.utils.theme.widget.ThemeTabLayout;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * by y on 2016/5/30.
 */
public class JokeMainPagerFragment extends BaseFragment {

    @SuppressWarnings("unused")
    @Bind(R.id.tab_layout)
    ThemeTabLayout tabLayout;
    @SuppressWarnings("unused")
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_joke_viewpager, null);
    }

    @Override
    protected void initData() {

        List<String> data = new LinkedList<>();
        data.add(UIUtils.getString(R.string.joke_text));
        data.add(UIUtils.getString(R.string.joke_pic));


        TabJokeAdapter adapter = new TabJokeAdapter(getChildFragmentManager(), data);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
