package com.hyetec.demo.di.module;

import android.arch.lifecycle.ViewModel;

import com.hyetec.demo.viewmodel.MainViewModel;
import com.hyetec.hmdp.core.di.scope.ViewModelScope;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author jimhan
 * @date 2017/7/31
 * Dagger MainViewModelModule
 * 包含ViewModelFactoryModule提供ViewModelProvider.Factory
 */
@Module(includes = {BaseModelModule.class})
public abstract class BaseViewModelModule {

    @Binds
    @IntoMap
    @ViewModelScope(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

    //    @Binds
    //    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
