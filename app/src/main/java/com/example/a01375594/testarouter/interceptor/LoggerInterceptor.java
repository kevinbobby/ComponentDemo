package com.example.a01375594.testarouter.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Created by 01375594 on 2018/5/8.
 */
@Interceptor(priority = 1)
public class LoggerInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        System.out.println("LoggerInterceptor: " + postcard);
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        System.out.println("初始化：LoggerInterceptor");
    }
}
