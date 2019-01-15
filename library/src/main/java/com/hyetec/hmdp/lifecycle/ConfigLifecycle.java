package com.hyetec.hmdp.lifecycle;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.hyetec.hmdp.lifecycle.delegate.AppLifecycles;

import java.util.List;


/**
 * @author xiaobailong24
 * @date 2017/6/16
 * 框架配置接口
 */
public interface ConfigLifecycle {

    /**
     * 使用 {@link AppLifecycles} 在 Application 的生命周期中注入一些操作
     *
     * @param context:    Context
     * @param lifecycles: List<AppLifecycles>
     */
    void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles);

    /**
     * 使用 {@link Application.ActivityLifecycleCallbacks} 在 Activity 的生命周期中注入一些操作
     *
     * @param context:    Context
     * @param lifecycles: List<Application.ActivityLifecycleCallbacks>
     */
    void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles);


    /**
     * 使用 {@link FragmentManager.FragmentLifecycleCallbacks} 在 Fragment 的生命周期中注入一些操作
     *
     * @param context:    Context
     * @param lifecycles: List<FragmentManager.FragmentLifecycleCallbacks>
     */
    void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles);
}
