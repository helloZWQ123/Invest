package com.atguigu.invest.fragment;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.invest.R;
import com.atguigu.invest.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LiXin on 2017/3/10.
 */
public class HomeFragment extends BaseFragment {
    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_back)
    ImageView baseBack;
    @Bind(R.id.base_setting)
    ImageView baseSetting;

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
