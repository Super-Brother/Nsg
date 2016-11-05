package top.yokey.nsg.utility;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.webkit.WebSettings;
import android.webkit.WebView;

import top.yokey.nsg.adapter.BasePagerAdapter;
import top.yokey.nsg.R;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：控件工具类
*
*/

public class ControlUtil {

    /*
    * 作用：设置 TabLayout
    */
    public static void setTabLayout(Activity activity, TabLayout mTabLayout, BasePagerAdapter mAdapter, ViewPager mViewPager) {

        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(activity, R.color.main));
        mTabLayout.setTabTextColors(ContextCompat.getColor(activity, R.color.greyAdd), ContextCompat.getColor(activity, R.color.main));
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    /*
    * 作用：设置 SwipeRefreshLayout
    */
    public static void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {

        swipeRefreshLayout.setColorSchemeResources(R.color.main, R.color.circle);

    }

    /*
    * 作用：设置 WebView
    */
    public static void setWebView(WebView webView) {

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

    }
}
