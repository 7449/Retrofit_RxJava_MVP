package com.example.y.mvp.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.y.mvp.R;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.theme.widget.ThemeToolbar;

import butterknife.Bind;

/**
 * by y on 2016/5/11.
 */
@SuppressWarnings("ALL")
public class WebViewActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


    @SuppressWarnings("unused")
    @Bind(R.id.webView)
    WebView webView;
    @SuppressWarnings("unused")
    @Bind(R.id.toolBar)
    ThemeToolbar toolBar;
    @SuppressWarnings("unused")
    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;
    private String url;
    private String title;


    public static void startIntent(String url, String title) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("title", title);
        ActivityUtils.startActivity(WebViewActivity.class, bundle);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBundle();
        init();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        toolBar.setTitle(title);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                srfLayout.setRefreshing(false);
            }
        });

        srfLayout.setOnRefreshListener(this);

        srfLayout.post(new Runnable() {
            @Override
            public void run() {
                srfLayout.setRefreshing(true);
                onRefresh();
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }


    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            url = bundle.getString("url");
            title = bundle.getString("title");
        }
    }

    @Override
    public void onRefresh() {
        webView.loadUrl(url);
    }
}
