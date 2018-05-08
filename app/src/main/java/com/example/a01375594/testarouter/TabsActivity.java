package com.example.a01375594.testarouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.a01375594.basemodule.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 01375594 on 2018/5/7.
 */
@Route(path = "/app/tabs")
public class TabsActivity extends BaseActivity {

    @Autowired()
    public String token;

    private TabLayout mainTabs;
    private ViewPager mainVp;

    private static String[] titles = {"历史", "消息"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        mainTabs = (TabLayout) findViewById(R.id.mainTabs);
        mainVp = (ViewPager) findViewById(R.id.mainVp);

//        token = "123456";

        Fragment historyFragment = (Fragment) ARouter.getInstance()
                .build("/history/listFragment")
                .withString("token", token)
                .navigation();

        Fragment messageFragment = (Fragment) ARouter.getInstance()
                .build("/message/listFragment")
                .withString("token", token)
                .navigation();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(historyFragment);
        fragments.add(messageFragment);

        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager(), fragments, titles);
        mainVp.setAdapter(tabsPagerAdapter);
        mainTabs.setupWithViewPager(mainVp);




    }
}
