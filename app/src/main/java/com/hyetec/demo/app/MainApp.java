package com.hyetec.demo.app;

import com.hyetec.demo.di.component.DaggerAppComponent;
import com.hyetec.hmdp.core.base.BaseApplication;
import com.hyetec.demo.di.component.AppComponent;

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
