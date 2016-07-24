package com.longlong.gankio.view.Activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.longlong.gankio.R;
import com.longlong.gankio.presenter.PresenterActivity.PresenterWeb;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:  Chenglong.Lu
 * Email:   1053998178@qq.com | w490576578@gmail.com
 * Date:   2016/07/22
 * Description:
 */
@RequiresPresenter(PresenterWeb.class)
public class ActivityWeb extends BeamBaseActivity<PresenterWeb> {
    @BindView(R.id.web_view)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
    }
    public WebView getWebView() {
        return webView;
    }
}
