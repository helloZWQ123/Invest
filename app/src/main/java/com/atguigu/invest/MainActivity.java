package com.atguigu.invest;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.atguigu.invest.fragment.HomeFragment;
import com.atguigu.invest.fragment.InvestFragment;
import com.atguigu.invest.fragment.MoreFragment;
import com.atguigu.invest.fragment.PropertFragment;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    private HomeFragment homeFragment;
    private InvestFragment investFragment;
    private PropertFragment propertFragment;
    private MoreFragment moreFragment;
    private FragmentTransaction ft;
    private boolean isBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListener();
        initData();
    }

    private void initData() {
        switchFragment(R.id.rb_home);
    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switchFragment(checkedId);
            }
        });
    }

    private void switchFragment(int checkedId) {
        ft = getSupportFragmentManager().beginTransaction();
        hiddenFragment(checkedId);
        switch (checkedId) {
            case R.id.rb_home :
                if(homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.fl_main,homeFragment);
                }else {
                    ft.show(homeFragment);
                }
                break;
            case R.id.rb_invest :
                if(investFragment == null) {
                    investFragment = new InvestFragment();
                    ft.add(R.id.fl_main,investFragment);
                } else {
                    ft.show(investFragment);
                }
                break;
            case R.id.rb_propert :
                if(propertFragment == null) {
                    propertFragment = new PropertFragment();
                    ft.add(R.id.fl_main,propertFragment);
                } else {
                    ft.show(propertFragment);
                }
                break;
            case R.id.rb_more :
                if(moreFragment == null) {
                    moreFragment = new MoreFragment();
                    ft.add(R.id.fl_main,moreFragment);
                }else {
                    ft.show(moreFragment);
                }
                break;
        }
        ft.commit();
    }

    private void hiddenFragment(int checkedId) {
        if(homeFragment != null) {
            ft.hide(homeFragment);
        }
        if(investFragment != null) {
            ft.hide(investFragment);
        }
        if(propertFragment != null) {
            ft.hide(propertFragment);
        }
        if(moreFragment != null) {
            ft.hide(moreFragment);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(MainActivity.this, "再次点击退出", Toast.LENGTH_SHORT).show();
        if(isBack) {
            finish();
        }
        isBack = true;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                isBack = false;
            }
        },2000);


        return true;
    }
}
