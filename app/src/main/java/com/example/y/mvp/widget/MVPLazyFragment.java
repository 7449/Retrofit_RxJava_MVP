package com.example.y.mvp.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.y.mvp.utils.RxUtils;

import butterknife.ButterKnife;

/**
 * by y on 2017/3/9.
 */

public abstract class MVPLazyFragment extends Fragment {
    protected static final String FRAGMENT_INDEX = "fragment_index";
    protected boolean isLoad;
    protected boolean isPrepared;
    protected boolean isVisible;
    protected View view;
    protected int index = 0;
    protected int page = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            index = bundle.getInt(FRAGMENT_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = getLayoutInflater(savedInstanceState).inflate(getLayoutId(), null);
            isPrepared = true;
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initActivityCreated();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
        }
    }

    protected void Toast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
    }

    private void onVisible() {
        initActivityCreated();
    }

    protected abstract void initActivityCreated();

    protected abstract int getLayoutId();

    protected void setLoad() {
        isLoad = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        RxUtils.getInstance().unSubscription();
    }
}
