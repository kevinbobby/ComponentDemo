package com.example.a01375594.historyModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.a01375594.basemodule.BaseActivity;

/**
 * Created by 01375594 on 2018/5/8.
 */
@Route(path = "/history/detail")
public class HistoryDetailActivity extends BaseActivity {

    @Autowired()
    public int id;

    @Autowired()
    public String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity_detail);

        getSupportActionBar().setTitle("历史详情");
        TextView detailTv = (TextView) findViewById(R.id.detailTv);
        detailTv.setText("id: " + id + "\nname: " + name);
    }
}
