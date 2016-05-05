package com.example.y.mvp.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.AboutAdapter;
import com.example.y.mvp.constant.Constant;
import com.example.y.mvp.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * by 12406 on 2016/5/2.
 */
public class AboutFragment extends BaseFragment {


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private AboutAdapter aboutAdapter;
    private List<String> list;

    @Override
    public View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_about, null);
    }

    @Override
    public void initData() {

        list = new ArrayList<>();

        list.add(UIUtils.getString(R.string.about_text1));
        list.add(UIUtils.getString(R.string.about_text2));


        aboutAdapter = new AboutAdapter(list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(aboutAdapter);
    }


}
