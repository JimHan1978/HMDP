package com.hyetec.hmdp.core.di.module;

import android.app.Application;
import android.support.v4.util.ArrayMap;

import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author xiaobailong24
 * @date 2017/7/13
 * Dagger ArmsModule
 */
@Module
public class ArchModule {
    private Application mApplication;

    public ArchModule(Application application) {
        this.mApplication = application;
    }


    @Singleton
    @Provides
    Application provideApplication() {
        return this.mApplication;
    }

    @Singleton
    @Provides
    Map<String, Object> provideExtras() {
        return new ArrayMap<>();
    }

}
