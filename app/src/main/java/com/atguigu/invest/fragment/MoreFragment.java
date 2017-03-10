package com.atguigu.invest.fragment;


import android.view.View;
import android.widget.TextView;

import com.atguigu.invest.base.BaseFragment;

/**
 * Created by LiXin on 2017/3/10.
 */
public class MoreFragment extends BaseFragment{
    private TextView textView;

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setText("更多");
        return textView;
    }
}
