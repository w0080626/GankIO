package com.longlong.gankio.module.web;

import android.support.annotation.NonNull;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jude.beam.expansion.BeamBasePresenter;
import com.longlong.gankio.R;
import com.longlong.gankio.entity.Result;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
public class PresenterWeb extends BeamBasePresenter<ActivityWeb> {
    WebView webView;

    Result result;

    @Override
    protected void onCreateView(@NonNull ActivityWeb view) {
        super.onCreateView(view);
//        view.getExpansion().showProgressPage();
        webView = view.getWebView();
        result = getDataFromIntent();
        initWebView();
        initToolBar();

    }

    private void initToolBar() {
        getView().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getView().getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        getView().getSupportActionBar().setTitle(result.getDesc());
    }

    public void initWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.getSettings().setAppCacheEnabled(true);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
//                    getView().getExpansion().dismissProgressPage();
                }
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(result.getUrl());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.removeAllViews();
            webView.destroy();
        }
    }
}
