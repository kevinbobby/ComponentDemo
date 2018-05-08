package com.example.a01375594.loginModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.a01375594.basemodule.BaseActivity;

/**
 * Created by 01375594 on 2018/5/8.
 */
public class LoginActivity extends BaseActivity {

    private EditText tokenEdt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        tokenEdt = (EditText) findViewById(R.id.tokenEdt);
    }

    public void login(View view) {
        ARouter.getInstance()
                .build("/app/tabs")
                .withString("token", tokenEdt.getText().toString().trim())
                .navigation(this, new NavCallback() {

                    @Override
                    public void onFound(Postcard postcard) {
                        super.onFound(postcard);
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        super.onLost(postcard);
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        System.out.println("ARouter跳转完毕，关闭页面");
                        finish();
                    }

                    @Override
                    public void onInterrupt(final Postcard postcard) {
                        // 拦截器的process()方法以及带跳转的回调中的onInterrupt(Postcard postcard)方法，
                        // 均是在分线程中执行的，如果需要做一些页面的操作显示，必须在主线程中执行
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, postcard.getTag().toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
    }
}
