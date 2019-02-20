package com.hyetec.demo.di.module;

import com.hyetec.demo.model.ContactsModel;
import com.hyetec.demo.model.MessageModel;
import com.hyetec.hmdp.core.di.scope.FragmentScope;
import com.hyetec.hmdp.core.mvvm.IModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author : created by jimhan
 * 版本：1.0
 * 创建日期：2019/2/20
 * 描述：
 **/
@Module
public class ContactsModule {
    @FragmentScope
    @Provides
    IModel provideContactsModel(ContactsModel contactsModel) {
        return contactsModel;
    }
}
