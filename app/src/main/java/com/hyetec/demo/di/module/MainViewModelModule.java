package com.hyetec.demo.di.module;

import android.arch.lifecycle.ViewModel;

import com.hyetec.demo.viewmodel.MainViewModel;
import com.hyetec.hmdp.core.di.scope.ViewModelScope;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author : created by jimhan
 * 版本：1.0
 * 创建日期：${DATE}
 * 描述：
 **/

@Module(includes = {MainModule.class})
public abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelScope(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);
}
