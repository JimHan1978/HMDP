package com.hyetec.demo.app;

import com.didichuxing.doraemonkit.DoraemonKit;
import com.hyetec.demo.di.component.AppComponent;
import com.hyetec.demo.di.component.DaggerAppComponent;
import com.hyetec.hmdp.core.base.BaseApplication;

/**
 * @author xiaobailong24
 * @date 2017/7/13
 * MainApp 配置框架
 * {@link BaseApplication}
 */
public class MainApp extends BaseApplication {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        DoraemonKit.install(this);
        mAppComponent = DaggerAppComponent
                .builder()
                .archComponent(getArchComponent())
                .build();
        mAppComponent.inject(this);

    }


    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }

}
