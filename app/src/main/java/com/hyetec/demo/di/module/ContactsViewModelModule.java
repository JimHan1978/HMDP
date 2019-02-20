package com.hyetec.demo.di.module;

import android.arch.lifecycle.ViewModel;

import com.hyetec.demo.viewmodel.ContactsViewModel;
import com.hyetec.demo.viewmodel.MessageViewModel;
import com.hyetec.hmdp.core.di.scope.ViewModelScope;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author : created by Administrator
 * 版本：1.0
 * 创建日期：2019/2/20
 * 描述：
 **/
@Module(includes = {ContactsModule.class})
public abstract class ContactsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelScope(ContactsViewModel.class)
    abstract ViewModel bindContactsViewModel(ContactsViewModel contactsViewModel);
}
