package com.example.a01375594.testarouter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.a01375594.basemodule.BaseActivity;

@Route(path = "/app/detail")
public class DetailActivity extends BaseActivity {

    @Autowired()
    String name ;

    @Autowired()
    String desc ;

    @Autowired(name = "age")
    int age ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView inputParamsTv = (TextView) findViewById(R.id.inputParamsTv);
        inputParamsTv.setText(inputParamsTv.getText().toString().trim() + "\ndesc: " + desc + "\nname: " + name + "\nage: " + age);
    }

    public void goBack(View view) {
        finish();
    }
}
