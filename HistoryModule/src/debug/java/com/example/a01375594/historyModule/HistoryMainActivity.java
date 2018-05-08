package com.example.a01375594.historyModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.a01375594.basemodule.BaseActivity;

/**
 * Created by 01375594 on 2018/5/4.
 */
@Route(path = "/history/main")
public class HistoryMainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment historyFragment = (Fragment) ARouter.getInstance()
                .build("/history/listFragment")
                .withString("token", "我从History测试页面而来")
                .navigation();
        transaction.replace(R.id.testFrameLayout, historyFragment);
        transaction.commitAllowingStateLoss();
    }
}
