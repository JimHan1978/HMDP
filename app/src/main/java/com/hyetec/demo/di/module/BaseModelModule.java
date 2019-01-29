package com.hyetec.demo.di.module;

import com.hyetec.demo.model.MainModel;
import com.hyetec.hmdp.core.di.scope.ActivityScope;
import com.hyetec.hmdp.core.mvvm.IModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author jimhan
 * @date 2017/7/31
 * Dagger WeatherModule
 */
@Module
public class BaseModelModule {

    @ActivityScope
    @Provides
    public IModel provideMainModel(MainModel mainModel) {
        return mainModel;
    }
}
