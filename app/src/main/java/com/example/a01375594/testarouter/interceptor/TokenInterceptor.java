package com.example.a01375594.testarouter.interceptor;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import java.security.InvalidParameterException;

/**
 * Created by 01375594 on 2018/5/8.
 */
@Interceptor(priority = 2)
public class TokenInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String token = postcard.getExtras().getString("token");
        if (TextUtils.isEmpty(token)) {
            callback.onInterrupt(new InvalidParameterException("token都不给，你是闹哪样？"));
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        System.out.println("初始化：TokenInterceptor");
    }
}
