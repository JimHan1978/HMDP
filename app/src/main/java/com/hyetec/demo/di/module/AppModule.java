package com.hyetec.demo.di.module;

import android.app.Application;

import com.hyetec.hmdp.core.di.module.ViewModelFactoryModule;

import dagger.Module;

/**
 * @author xiaobailong24
 * @date 2017/7/22
 * Dagger AppModule
 */
@Module(includes = {ViewModelFactoryModule.class
//        ,
//        WeatherActivityModule.class,
//        WeatherNowFragmentModule.class,
//        WeatherDailyFragmentModule.class
})
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

}
