package com.example.y.mvp.fragment;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.AboutAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.widget.MVPLazyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/2.
 */
public class AboutFragment extends MVPLazyFragment {


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    public static AboutFragment getInstance() {
        return new AboutFragment();
    }

    @Override
    public void initActivityCreated() {
        List<String> list = new ArrayList<>();
        list.add(UIUtils.getString(R.string.about_text1));
        list.add(UIUtils.getString(R.string.about_text2));
        AboutAdapter aboutAdapter = new AboutAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(aboutAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }


}
