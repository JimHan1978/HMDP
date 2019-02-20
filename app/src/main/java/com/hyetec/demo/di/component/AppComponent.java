package com.hyetec.demo.di.component;

import com.hyetec.demo.app.MainApp;
import com.hyetec.hmdp.core.di.component.ArchComponent;
import com.hyetec.hmdp.core.di.scope.AppScope;
import com.hyetec.demo.di.module.AppModule;
import com.hyetec.demo.di.module.BaseActivityModule;
import com.hyetec.demo.di.module.FragmentBuildersModule;

import dagger.Component;

/**
 * @author xiaobailong24
 * @date 2017/7/15
 * Dagger AppComponent
 */
@AppScope
@Component(dependencies = ArchComponent.class,
        modules = {AppModule.class})
public interface AppComponent {
    /**
     * Dagger 注入
     *
     * @param mainApp MainApp
     */
    void inject(MainApp mainApp);
}
