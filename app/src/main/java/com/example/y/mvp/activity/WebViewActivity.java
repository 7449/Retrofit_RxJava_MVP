package com.example.y.mvp.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.y.mvp.R;

import butterknife.Bind;

/**
 * by y on 2016/5/11.
 */
public class WebViewActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


    @Bind(R.id.webView)
    WebView webView;
    @Bind(R.id.toolBar)
    Toolbar toolBar;
    @Bind(R.id.srf_layout)
    SwipeRefreshLayout srfLayout;
    private String url;
    private String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBundle();
        init();
    }

    private void init() {
        toolBar.setTitle(title);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

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


    public void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        url = bundle.getString("url");
        title = bundle.getString("title");
    }

    @Override
    public void onRefresh() {
        webView.loadUrl(url);
    }
}
